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
static void scan_region(uintptr_t *sp, uintptr_t *end)	// 		need more test [-] [+]
{

	header_t *p;
	header_t *prevp;	

	while (sp < end) {		// from start to end set region	//	<--- test more here  [+]
			prevp = usedp;
			header_t *temp;		//  	to take variable but not UNTAG() them
			for (p = UNTAG(prevp->next); UNTAG(p->next) != NULL; prevp = UNTAG(p), temp = UNTAG(p), p = UNTAG(temp->next)) {	// go through the used list
				if (((header_t *)*sp) - 1 == UNTAG(p)) {
					p = (header_t *)((uintptr_t)p | 1);
					temp = UNTAG(prevp);
					temp->next = p;
				} 		
			}
			if (((header_t *)*sp) - 1 == UNTAG(usedp)) {
				usedp = (header_t *)((uintptr_t)usedp | 1);
			} 
	sp++; 
	}

}

/*
 * Scan the marked blocks for references to other unmarked blocks.
 */
static void scan_heap(void)		// 			didn't watch 
{
    header_t *p;

	header_t *temp;		// 	make all things like in scan_region()
	for (p = UNTAG(usedp), temp = UNTAG(p); UNTAG(temp->p) != NULL; temp = UNTAG(p), p = UNTAG(temp->next)) {
		scan_region((uintptr_t *)p, (uintptr_t *)(p + p->size));
	}
}            

static void collect () {
	//		here usedp->next->next->next = 5793
	header_t *prevp = UNTAG(usedp);
	header_t *p;
	header_t *temp; 	// make all things like in scan_region()

	for (p = UNTAG(prevp->next); UNTAG(p->next) != NULL; prevp = UNTAG(p), temp = UNTAG(p), p = UNTAG(temp->next)) {
		if (p != UNTAG(p)) {
			temp = UNTAG(p);
			prevp->next = temp->next;
			add_to_free_list(UNTAG(p));		
		}
	}
	
	if (prevp != usedp) {
		temp = UNTAG(prevp);
		add_to_free_list(prevp);
		usedp = temp->next;
	}

	prevp = UNTAG(usedp);
	for (p = UNTAG(prevp->next); UNTAG(p->next) != NULL; prevp = UNTAG(p), temp = UNTAG(p), p = UNTAG(temp->next)) {
		prevp->next = UNTAG(p);
		p = UNTAG(p);
	}
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
	for (p = usedp; p->next != NULL && p->size != 0; p = p->next) {	// p->size != 0 ??? [-]
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

    char *x = (char *)GC_malloc(10);
	printf("[+] x pointer : %p \t\t(-1)\n", x - 16);
	printf("[+] x adress : %p \n", &x);
	display_lists();

	char *x2 = (char *)GC_malloc(3000);
	printf("[+] x2 pointer : %p \t\t(-1)\n", x2 - 16);
	printf("[+] x2 adress : %p \n", &x2);
	display_lists();

	char *x3 = (char *)GC_malloc(4000);
	printf("[+] x3 pointer : %p \t\t(-1)\n", x3 - 16);
	printf("[+] x3 adress : %p \n", &x3);
	display_lists();

	char *x4 = (char *)GC_malloc(5000);
	printf("[+] x4 pointer : %p \t\t(-1)\n", x4 - 16);
	printf("[+] x4 adress : %p \n", &x4);
	display_lists();

	char *x5 = (char *)GC_malloc(6000);
	printf("[+] x5 pointer : %p \t\t(-1)\n", x5 - 16);
	printf("[+] x5 adress : %p \n", &x5);
	display_lists();


	char *x6 = (char *)GC_malloc(7000);
	printf("[+] x6 pointer : %p \t\t(-1)\n", x6 - 16);
	printf("[+] x6 adress : %p \n", &x6);
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
	f = NULL;

    GC_collect();
	
	printf("[+] garbage_collect \n");
	display_lists();

    return 0;
}

