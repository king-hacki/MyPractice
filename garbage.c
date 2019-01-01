#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <unistd.h>
#include <assert.h>

//#include "garbage.h" 

#define MIN_ALLOC_SIZE 4096     /* We allocate blocks in page sized chunks. */
#define UNTAG(p) (header_t *)(((uintptr_t) (p)) & 0xfffffffffffe)

typedef struct header {
    unsigned int    size;
    struct header   *next;
} header_t;


static header_t base;           /* Zero sized block to get us started. */
static header_t *freep = &base; /* Points to first free block of memory. */
static header_t *usedp;         /* Points to first used block of memory. */
static unsigned long stack_bottom = 0; // if we don't initialize 0 dont't find in fscanf
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

	/*  problem 
		after first call morecore sbrk(0) = b000	
		so first block in usedp start freom b000, it has size 14 so next sbrk(0) 		
		should be 
	*/
		
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
                header_t *temp = p;
				temp += num_units;
				temp->size = p->size - num_units;
				temp->next = p->next;
				prevp->next = temp;
				p->size = num_units;	

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
    }
}

/*
 * Scan a region of memory and mark any items in the used list appropriately.
 * Both arguments should be word aligned.
 */
static void scan_region(uintptr_t *sp, uintptr_t *end)	// 		need more test
{

	header_t *p;
	header_t *prevp;	
	header_t *start_ptr = freep->next;
	header_t *last_ptr;

	header_t *end_use = usedp->next;
	header_t *end_free = freep->next;

	for (p = usedp; p->next != NULL; p = p->next){}
	end_use = p + p->size;
	
	for (p = freep; p->next != NULL; p = p->next){}
	end_free = p + p->size;

	if (end_free > end_use)
		last_ptr = end_free;
	else 
		last_ptr = end_use;

	while (sp < end) {		// from start to end set region	//	<--- test more here
		if ((uintptr_t *)start_ptr <= (uintptr_t *)*sp && 
			(uintptr_t *)last_ptr >= (uintptr_t *)*sp) {  
			prevp = usedp;
			for (p = UNTAG(prevp->next); p != NULL; prevp = UNTAG(p), p = p->next) {	// go through the used list
				if (((header_t *)*sp) - 1 == p) {
					p = (header_t *)((uintptr_t)p | 1);
					prevp->next = p;
				} 		
			}
			if (((header_t *)*sp) - 1 == prevp) {
				prevp = (header_t *)((uintptr_t)prevp | 1);
			} 
		}
	sp++; 
	}
}

/*
 * Scan the marked blocks for references to other unmarked blocks.
 */
static void scan_heap(void)
{
    uintptr_t *vp;
    header_t *bp, *up;

    for (bp = UNTAG(usedp->next); bp != NULL; bp = UNTAG(bp->next)) {
        if (!((uintptr_t)bp->next & 1))
            continue;
        for (vp = (uintptr_t *)(bp + 1); vp < (uintptr_t *)(bp + bp->size + 1); vp++) {
            uintptr_t v = *vp;
            up = UNTAG(bp->next);
            do {
                if (up != bp &&
                    (uintptr_t)(up + 1) <= v &&
                    (uintptr_t)(up + 1 + up->size) > v) {
                    up->next = (header_t *)(((uintptr_t) up->next) | 1);
                    break;
                }
            } while ((up = UNTAG(up->next)) != bp);
        }
    }
}

static void collect () {
	header_t *prevp = usedp;
	header_t *p;

	for (p = prevp; p != NULL; prevp = p, p = p->next) {
		if (p != UNTAG(p)) {
			if (UNTAG(p) == UNTAG(prevp)) 
				usedp->next = p->next;
			else 
				prevp->next = p->next;
			add_to_free_list(UNTAG(p));
		}
	}

	for (p = usedp; p != NULL; p = p->next) {
		p = UNTAG(p);
	} 

}

/*
 * Find the absolute bottom of the stack and set stuff up.
 */
void GC_init(void)
{
    static int initted;		// wtf?
    FILE *statfp;

    if (initted)		// for what?
        return;

    initted = 1;

    statfp = fopen("/proc/self/stat", "r");
    assert(statfp != NULL);
	// in /proc/self/stat file 28 value mean start stack
    fscanf(statfp,
           "%*d %*s %*c %*d %*d %*d %*d %*d %*u "
           "%*lu %*lu %*lu %*lu %*lu %*lu %*ld %*ld "
           "%*ld %*ld %*ld %*ld %*llu %*lu %*ld "
           "%*lu %*lu %*lu %lu", &stack_bottom);
    fclose(statfp);

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

	GC_init();	

    /* Scan the BSS and initialized data segments. */
    scan_region((uintptr_t *)&etext, (uintptr_t*)&end);

    /* Scan the stack. */
    asm volatile ("movq %%rbp, %0" : "=r" (stack_top));
    scan_region((uintptr_t *)stack_top, (uintptr_t *)stack_bottom);

    /* Mark from the heap. */
    scan_heap();

 /*    And now we collect! 	*/
	collect();

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

static void display_lists () {
	header_t *p;
	
	printf("\n FREE LIST { \n");
	for (p = freep; p != NULL; p = p->next) {
		printf("\t size : [%d]\n", p->size);
		printf("\t this block : [%p]\n", p);
		printf("\t next block : [%p]\n", p->next);
		printf("\t this block + size : [%p]\n", p + p->size);
	}
	printf("  }\n\n");

	printf("\n USE LIST { \n");
	for (p = usedp; p != NULL; p = p->next) {
		printf("\t size : [%d]\n", p->size);
		printf("\t this block : [%p]\n", (uintptr_t *)p);
		printf("\t next block : [%p]\n", p->next);
		printf("\t this block + size : [%p]\n", p + p->size);
	}
	printf("  }\n\n");
}

int main () 
{
    char *y = (char *)GC_malloc(200);
	printf("[+] y pointer : %p \t\t(-1)\n", y - 16);
	printf("[+] y adress : %p \n", &y);
	display_lists();

    char *x = (char *)GC_malloc(2000);
	printf("[+] x pointer : %p \t\t(-1)\n", x - 16);
	printf("[+] x adress : %p \n", &x);
	display_lists();
	
	GC_free(y);
	printf("[+] free : y \n");
	display_lists();

    char *v = (char *)GC_malloc(100);
	printf("[+] v pointer : %p \t\t(-1)\n", v - 16);
	printf("[+] v adress : %p \n", &v);
	display_lists();

	char *z = (char *)GC_malloc(300);
	printf("[+] z pointer : %p \t\t(-1)\n", z - 16);
	printf("[+] z adress : %p \n", &z);
	display_lists();


	GC_free(z);
	printf("[+] free : z \n");
	display_lists();

	GC_free(x);
	printf("[+] free : x \n");
	display_lists();

	GC_free(v);
	printf("[+] free : v \n");
	display_lists();

	char *e = (char *)GC_malloc(300);
	printf("[+] e pointer : %p \t\t(-1)\n", e - 16);
	printf("[+] e adress : %p \n", &e);
	display_lists();

	char *f = (char *)GC_malloc(700);
	printf("[+] f pointer : %p \t\t(-1)\n", f - 16);
	printf("[+] f adress : %p \n", &f);
	display_lists();

    e = NULL;
  
    GC_collect();

	printf("[+] garbage_collect \n");
	display_lists();

    return 0;
}

