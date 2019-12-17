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
int first_block_flag = 1; // for creating first block because of allocate due to sbrk more than need
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
static header_t *morecore()
{
    void *vp;
    header_t *up;

		
	/*
		When we run 126 (2016) in num_units sbrk() give 8192 -> 2048 * 4 	???
		This shit isn`t predictable so we change num_units before up->size
		noooo

		after first block sbrk allocate block from 8192	no matter what a size was allocated
		why ???

		i will fix it by allocating only 8192 memory
	
	*/

	/*
	
		VARIANT 1 
		first call morecore() allocate 8192 memory 
		and next calls will allocate memory as much as need.

	if (first_block_flag) {
		num_units = 512;
		first_block_flag = 0;
	}	 

    if ((vp = (void *)sbrk(num_units * sizeof(header_t))) == (void *) -1)
        return NULL;

	*/

	/* 
		VARIANT 2
		every call of morecore() allocate 8192 memory. I think this var. is better
	*/

	if ((vp = (void *) sbrk(512 * sizeof(header_t))) == (void *) -1)
		return 0;

	/*
		ufffffffffffffffffffffff
		EVERY TIME WHEN I CALL MORECORE() FIRSTLY HIS SBRK() GIVE ME MUCH MORE MEMORY WTF???
		at now i haven`t enough knowlege to tell what a fuck is going on
		in a future i will return to this chunk of code!!!	[-]		
	*/

    up = (header_t *) vp;
    up->size = 512;
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
			p = morecore();
			if (p == NULL) {
				return NULL;			
			}			
		}
        if (p->size >= num_units) { /* Big enough. */
            if (p->size == num_units) /* Exact size. */
                prevp->next = p->next;
            else {
                header_t *p2 = p;
                p2 = p + num_units;
                p2->size = p->size - num_units;
                p->size = num_units;
                p2->next = p->next;
                prevp->next = p2;
            }

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
	if (flag)	printf("[-] Not gc_malloc ptr : [ %p ] \n", take);
}

/*
 * Scan a region of memory and mark any items in the used list appropriately.
 * Both arguments should be word aligned.
 */
static void scan_region (uintptr_t *start, uintptr_t *end)	// 		scan set region and mark
{

	printf(" \n[+] scan_region method start \n");
	printf("[+] scan start in [ %p ] - scan end in [ %p ] \n\n", start, end);

	header_t *prev_block;
	prev_block->next = usedp;

	//		end here take care abovt prev_block->next not ( | 1) fix ......

	while ((uintptr_t)start < (uintptr_t) end) {
				
		for (block = usedp; UNTAG(block) != NULL;
		 untag_block = UNTAG(block), block = untag_block->next ) {			
			if ((uintptr_t) prev_block->next == (uintptr_t) ((header_t *)*start - 1)) {
				printf("[+] find block : [ %p ] \n", (header_t *)*start - 1);
				prev_block->next = (header_t *)((uintptr_t) block | 1);
				
			}
		}
		(uintptr_t) start++;
	}
	
	printf("\n");

}

/*
 * Scan the marked blocks for references to other unmarked blocks.
 */
static void scan_heap(void)		// 	scan heap
{
	header_t *block;
	header_t *untag_block;
	
	printf("\n[+] scan heap \n\n");
	
	for (block = UNTAG(usedp); UNTAG(block) != NULL; untag_block = UNTAG(block), block = UNTAG(untag_block->next)) {
		untag_block = UNTAG(block);
		scan_region((uintptr_t *) untag_block, (uintptr_t *) untag_block + untag_block->size);
	}
}            

static void collect () {	//		collect unmarked blocks
	
	header_t *block;
	header_t *untag_block;
	
	for (block = usedp; UNTAG(block) != NULL; untag_block = UNTAG(block), block = UNTAG(untag_block->next))
		if (block == UNTAG(block)) 
			GC_free(UNTAG(block) + 1);
			
	for (block = UNTAG(usedp); UNTAG(block) != NULL; untag_block = UNTAG(block), block = UNTAG(untag_block->next))
		block = UNTAG(block);
	
}

/*
 * Find the absolute bottom of the stack and set stuff up.
 */
static void GC_init(void)
{
    static int initted;		// wtf?
    FILE *statfp;

    if (initted)		// for what?	[+]
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
void GC_collect()
{
    header_t *p, *prevp, *tp;
    unsigned long stack_top;
    extern char end, etext; /* Provided by the linker. */

    if (usedp == NULL)
        return;

	GC_init();	

    /* Scan the BSS and initialized data segments. */
    scan_region((uintptr_t *)&etext, (uintptr_t *)&end);

    /* Scan the stack. */
    asm volatile ("movq %%rbp, %0" : "=r" (stack_top));
    scan_region((uintptr_t *)stack_top, (uintptr_t *)stack_bottom);

    /* Mark from the heap. */
    scan_heap();

 /*    And now we collect! 	*/
	collect();

}

void DIS () {


	printf("\n[+] free list \n");
	for (header_t *block = freep->next; block != NULL; block = block->next) 
		printf("\t[+] adress : [ %p ]\tsize : [ %d ]\tnext : [ %p ]\n", block, block->size, block->next);

	printf("[+] used list \n");
	for (header_t *block = usedp; block != NULL; block = block->next) 
		printf("\t[+] adress : [ %p ]\tsize : [ %d ]\tnext : [ %p ]\n", block, block->size, block->next);
	

}

int main () 
{
    char *y = (char *)GC_malloc(200);		
    printf("\n[+] allocate y");
    DIS();
    char *x = (char *)GC_malloc(1000);
    printf("\n[+] allocate x ");
	DIS();
	GC_free(y);
	printf("\n[+] free y");
    DIS();
    char *v = (char *)GC_malloc(100);
    printf("\n[+] allocate v ");
	DIS();
	char *z = (char *)GC_malloc(300);
	printf("\n[+] allocate z ");
	DIS();
	GC_free(z);
	printf("\n[+] free z ");
	DIS();
	char *e = (char *)GC_malloc(300);
	printf("\n[+] allocate e ");
	DIS();
	char *f = (char *)GC_malloc(700);
	printf("\n[+] allocate f ");
	DIS();
	
    e = NULL;
	f = NULL;
	
	printf("\n[+] y pointer : \t %p \t %p \n", y - 16, &y);
	printf("[+] x pointer : \t %p \t %p \n", x - 16, &x);
	printf("[+] v pointer : \t %p \t %p \n", v - 16, &v);
	printf("[+] z pointer : \t %p \t %p \n", z - 16, &z);
	printf("[+] e pointer : \t %p \t %p \n", e - 16, &e);
	printf("[+] f pointer : \t %p \t %p \n", f - 16, &f);

    GC_collect();
	
	printf("\n[+] garbage_collect ");
	DIS();
	
	printf("\n");

    return 0;
}

