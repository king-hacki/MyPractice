#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <unistd.h>

int main () 
{

    
    //printf("%d \n", 1 > 2);	// test on true - 1 and false - 0)

/*
    unsigned int x = 11111;
    unsigned int *p = malloc(5000);

    printf("%u %u \n", (uintptr_t)(p + 1), x);	// work with uintptr_t
    printf("%d \n", (uintptr_t)(p + 1) > x);
    printf("%d \n", sizeof(uintptr_t));		// sizeof(uintptr_t) = 8

/*
    printf("%u %u \n", (unsigned int)(p + 1), x);	// warrning cast from pointer to integer of different size 
    printf("%d \n", (unsigned int)(p + 1) > x);
*/

 //   printf("%lu \n", sbrk(4535));

/*	everything OK!!
 
	int x[5] = {1, 2, 3, 4, 5};
	int *x_ptr = (int *) sbrk(50);
	x_ptr = x;
*/

/*	next code without sbrk call case segmentation fault

	int y[5] = {1, 2, 3, 4, 5};
	int *y_ptr;
	y_ptr = p;	

*/




// why sizeof(header_t) = 16 when sizeof(test_t) = 4;??

/* 
*
*  why 
*  header t;
*  header *t_ptr = t;
*  t(0x7fffffffe140) + 1 = 0x7fffffffe150 and not 0x7fffffffe141
*  ????
*
*/
/*
typedef struct header {
    unsigned int    size;
    struct header   *next;
} header_t;

struct test {		// sizeof(16)
    int inttest;  
    struct test *next; 
} test_t;

struct test1 {		// sizeof(4)
    int inttest;  
    //struct test *next; 
} test_t1;

struct test2 {		// sizeof(8)
    //int inttest;  
    struct test2 *next; 
} test_t2;

struct test3 {		// sizeof(16)
    int inttest1;
    int inttest2;    
    struct test3 *next; 
} test_t3;

struct test4 {		// sizeof(24)
    int inttest1;
    int inttest2;  
    struct test4 *next; 
    struct test4 *next2;
} test_t4;

struct test5 {		// sizeof(32)
    int inttest1;  
    struct test5 *next;
    int inttest2; 
    struct test5 *next2;
} test_t5;

struct test6 {		// what will be here!? ---> 16 and it's right!!!
    char test;
    struct test6 *next;
} test_t6;

struct test_last {		// sizeof() here is also 16 
    char test;
    struct test_last *next;
} test_t_last;


    int arr[2] = {1, 2};

    header_t t;
    header_t *t_ptr = &t;  // t_ptr + 1 will add not 1 to an adress but 1 * sizeof(header_t = 16)

    int y;
    int *x = &y;	// x + 1 add 4

    long yl;
    long *xl = &yl;	   // and xl + 1 add 8

*/

	//	task
	//	take 5 value from file text.txt
	// in text [x 9 213412341235235 false 100 85 3234856 x]
	// * in %*s take string but miss

	FILE *test;
	int find = 0;
	test = fopen("text.txt", "r");
	printf("%d \n", find);
	fscanf(test, "%*c %*d %*lu %*s %d", &find);
	printf("%d \n", find);

    return 0;
}














