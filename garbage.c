#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <unistd.h>
#include <assert.h>

//#include "garbage.h" 

#define MIN_ALLOC_SIZE 4096     /* We allocate blocks in page sized chunks. */
#define UNTAG(p) (((uintptr_t) (p)) & 0xfffffffc)

typedef struct header {
    unsigned int    size;
    struct header   *next;
} header_t;


static header_t base;           /* Zero sized block to get us started. */
static header_t *freep = &base; /* Points to first free block of memory. */
static header_t *usedp;         /* Points to first used block of memory. */
static unsigned long stack_bottom;
/*
 * Scan the free list and look for a place to put the block. Basically, we're
 * looking for any block the to be freed block might have been partitioned from.
 */
static void add_to_free_list(header_t *bp)
{
    header_t *p;

///*	reason of this code ?	okay reason in p = p->next)))

    for (p = freep; !(bp > p && bp < p->next); p = p->next)
        if (p >= p->next && (bp > p || bp < p->next))
            break;


    if (bp + bp->size == p->next) {
        bp->size += p->next->size;
        bp->next = p->next->next;
    } else
        bp->next = p->next;

    if (p + p->size == bp) {
        p->size += bp->size;
        p->next = bp->next;
    } else
        p->next = bp;
}

/*
 * Request more memory from the kernel.
 */
static header_t *morecore(size_t num_units)
{
    void *vp;
    header_t *up;

    if (num_units > MIN_ALLOC_SIZE)
        num_units = MIN_ALLOC_SIZE / sizeof(header_t);

    if ((vp = (void *)sbrk(num_units * sizeof(header_t))) == (void *) -1)
        return NULL;

    up = (header_t *) vp;
    up->size = num_units;
    add_to_free_list (up);
    return freep;
}

/*
 * Find a chunk from the free list and put it in the used list.
 */
void *GC_malloc(size_t alloc_size)
{
    size_t num_units;
    header_t *p, *prevp;

    num_units = (alloc_size + sizeof(header_t) - 1) / sizeof(header_t) + 1;  
    prevp = freep;

    for (p = prevp->next;; prevp = p, p = p->next) {
		if (p == NULL) {
			p = morecore(num_units);
			if (p == NULL) {
				return NULL;			
			}			
		}
        if (p->size >= num_units) { /* Big enough. */
            if (p->size == num_units) /* Exact size. */
                prevp->next = p->next;
            else {
                p->size -= num_units;
				header_t *temp = p;
				temp->size = p->size;
				temp->next = p->next;
                p += p->size;
                p->size = num_units;
				add_to_free_list(temp);	///	<------------ 	START FROM HERE TOMORROW
            }

            // freep = prevp;			wtf? I think this don't need

            /* Add to p to the used list. */
            if (usedp == NULL)  
                usedp  = p;
            else {
                p->next = usedp->next;
                usedp->next = p;
            }

            return (void *) (p + 1);
        }
/*
        if (p == NULL) { /* Not enough memory. 
            p = morecore(num_units);
            if (p == NULL) /* Request for more memory failed. 
                return NULL;
        }	*/
    }
}

/*
 * Scan a region of memory and mark any items in the used list appropriately.
 * Both arguments should be word aligned.
 */
static void scan_region(unsigned int *sp, unsigned int *end)
{
    header_t *bp;

    for (; sp < end; sp++) {
        unsigned int v = *sp;
        bp = usedp;
        do {
            if ((uintptr_t)(bp + 1) <= v &&
                (uintptr_t)(bp + 1 + bp->size) > v) {
                    bp->next = (header_t *)(((uintptr_t) bp->next) | 1);
                    break;
            }
        } while ((bp = (header_t *)UNTAG(bp->next)) != usedp);
    }
}

/*
 * Scan the marked blocks for references to other unmarked blocks.
 */
static void scan_heap(void)
{
    unsigned int *vp;
    header_t *bp, *up;

    for (bp = (header_t *)UNTAG(usedp->next); bp != usedp; bp = (header_t *)UNTAG(bp->next)) {
        if (!((uintptr_t)bp->next & 1))
            continue;
        for (vp = (unsigned int *)(bp + 1); vp < (unsigned int *)(bp + bp->size + 1); vp++) {
            unsigned int v = *vp;
            up = (header_t *)UNTAG(bp->next);
            do {
                if (up != bp &&
                    (uintptr_t)(up + 1) <= v &&
                    (uintptr_t)(up + 1 + up->size) > v) {
                    up->next = (header_t *)(((uintptr_t) up->next) | 1);
                    break;
                }
            } while ((up = (header_t *)UNTAG(up->next)) != bp);
        }
    }
}

/*
 * Find the absolute bottom of the stack and set stuff up.
 */
void GC_init(void)
{
    static int initted;
    FILE *statfp;

    if (initted)
        return;

    initted = 1;

    statfp = fopen("/proc/self/stat", "r");
    assert(statfp != NULL);
    fscanf(statfp,
           "%*d %*s %*c %*d %*d %*d %*d %*d %*u "
           "%*lu %*lu %*lu %*lu %*lu %*lu %*ld %*ld "
           "%*ld %*ld %*ld %*ld %*llu %*lu %*ld "
           "%*lu %*lu %*lu %lu", &stack_bottom);
    fclose(statfp);

    usedp = NULL;
    base.next = freep = &base;
    base.size = 0;
}

/*
 * Mark blocks of memory in use and free the ones not in use.
 */
void GC_collect(void)
{
    header_t *p, *prevp, *tp;
    unsigned long stack_top;
    extern char end, etext; /* Provided by the linker. */

    if (usedp == NULL)
        return;

    /* Scan the BSS and initialized data segments. */
    scan_region((unsigned int *)&etext, (unsigned int *)&end);

    /* Scan the stack. */
    asm volatile ("movq %%rbp, %0" : "=r" (stack_top));
    scan_region((unsigned int *)stack_top, (unsigned int *)stack_bottom);

    /* Mark from the heap. */
    scan_heap();

    /* And now we collect! */
    for (prevp = usedp, p = (header_t *)UNTAG(usedp->next);; prevp = p, p = (header_t *)UNTAG(p->next)) {
    next_chunk:
        if (!((uintptr_t)p->next & 1)) {
            /*
             * The chunk hasn't been marked. Thus, it must be set free. 
             */
            tp = p;
            p = (header_t *)UNTAG(p->next);
            add_to_free_list(tp);

            if (usedp == tp) { 
                usedp = NULL;
                break;
            }

            prevp->next = (header_t *)((uintptr_t)p | ((uintptr_t) prevp->next & 1));
            goto next_chunk;
        }
        p->next = (header_t *)(((uintptr_t) p->next) & ~1);
        if (p == usedp)
            break;
    }
}

void GC_free (void *ptr) {
	header_t *take = (header_t *) ptr;
	take -= 1;
	int flag = 1;

	if (take == usedp) {
		flag = 0;
		usedp = take->next;
		add_to_free_list(take);
	} else {
		for (header_t *p = usedp; p != NULL; p = p->next) {
			if (p->next == take) {
				flag = 0;
				p->next = take->next;
				add_to_free_list(take);
				break;
			}
		}
	}
	if (flag)	printf("[-] Not gc_malloc ptr \n");
}


int main () 
{
    char *y = (char *)GC_malloc(200);
    char *x = (char *)GC_malloc(2000);
	GC_free(y);
    char *v = (char *)GC_malloc(100);
	char *z = (char *)GC_malloc(300);
	GC_free(z);
	GC_free(x);
	GC_free(v);
	char *e = (char *)GC_malloc(300);

    e = NULL;

    GC_init();
    GC_collect();

    return 0;
}

