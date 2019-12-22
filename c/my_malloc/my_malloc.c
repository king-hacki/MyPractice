тест

#include <stdio.h>
#include <unistd.h>

struct meta {
	
        int size;		// 4 byte
        int free;		// 4 byte
        struct meta *next;	// 8 byte
	struct meta *prev;	// 8 byte
        void *ptr;		// 8 byte
				// 32 byte
        char end[1];
};

typedef struct meta *meta;

#define align(x) (((((x)-1)>>2)<<2)+4)
#define META_SIZE sizeof(meta)
#define TRUE 1

void *my_malloc(int size);
void *my_calloc(int number, int size);
void *my_realloc(void *p, int size);
meta fusion(meta block);
meta get_block(void *ptr);
int valid_ptr(void *ptr);
void free(void *ptr);
void split_block(meta block, int size);
meta find_free_block(int size);
meta extend_memory(meta last, int size);
void copy_block(meta src, meta dst);

meta base = NULL;

int main () {

        int *p1 = (int *)my_malloc(100);
        int *p2 = (int *)my_malloc(30);
        int *p3 = (int *)my_malloc(50);
        free((void *)p1);
        int *p4 = (int *)my_malloc(40);
	free((void *)p2);
	free((void *)p3);
	int *p5 = (int *)my_malloc(80);
	
//        printf("%d %d \n", ptr[30], ptr[50]);

return 0;
}

// allocate memory area for us
// return pointer on memory which we can use

void *my_malloc (int size) {

        meta block, last;

        size = align(size);
        if (!base) {
                block = extend_memory(base, size);
                if (!block) return NULL;
                base = block;
        } else {
                block = find_free_block(size);
                if (block) {
                        if ((block->size - size) >= (META_SIZE * 4))
                                 split_block(block, size);
                } else {
                        meta last;
                        meta temp = base;
                        while (TRUE) {
                                if (temp->next == base) {
                                        last = temp;
                                        break;
                                } else temp = temp->next;
                        }

                        block = extend_memory(last, size);
                        if (!block) return NULL;
                }
        }

        return (void *)(block->end);
}

// fusion two blocks after freeded one of them
// return fusioned block

meta fusion (meta block) {
	
	block->size += block->next->size + META_SIZE * 4;
	block->next->next->prev = block;
	block->next = block->next->next;
        	
        return block;
}

// get pointer on meta-block

meta get_block (void *ptr) {
        return (meta)(ptr - META_SIZE * 4);
}		

// pointer validation check is it reallu malloc pointer
int valid_ptr (void *ptr) {

        if (base) {
                if (ptr > (void *)base && ptr < sbrk(0)) {
                        return 	TRUE;
                }
        }
 
        return 0;
}

// make block of memory free and ready to use

void free (void *ptr) {

        meta block;

        if (valid_ptr(ptr)) {
                block = get_block(ptr);
                block->free = 1;
                if (block->next->free) {
			block = fusion(block);
                }
                if (block->prev->free) {               	
			block = fusion(block->prev);
                }
        }
}

// split block into two blocks with meta

void split_block (meta block, int size) {

        meta new_block;
        int temp_size;

        size = align(size);
        new_block = (meta)(block->end + size);
        new_block->free = 1;
        temp_size = block->size;
        block->size = size;
        new_block->size = temp_size - size - META_SIZE * 4;
	block->next->prev = new_block;
        new_block->next = block->next;
        new_block->prev = block;
        block->next = new_block;
	block->free = 0;

	if (new_block->next->free) {
		block = fusion(block);
	}

}

// find free and good-sized block
// return this block if it is

meta find_free_block (int size) {

        meta block = base;
	meta returned_block;

        size = align(size);
        while (TRUE) {
                if ((block->free) && (block->size >= size)) {
                        returned_block = block;
			break;
		}
                if (block->next == base) break;
                block = block->next;
        }
        return returned_block;
}

// extends break in heap and return pointer
// on meta-block for extended memory

meta extend_memory (meta last, int size) {

        meta block;

        size = align(size);
        block = (meta)sbrk(0);
        if (sbrk(size + META_SIZE) == (void *) -1)
                return NULL;
        block->size = size;
        block->free = 0;
        if (last) {
                block->next = base;
		block->prev = last;
		last->next = block;
		base->prev = block;
        } else {
                block->prev = block;
                block->next = block;
        }

        return block;
}

void *my_calloc (int number, int size) {

	int *new;
	int s4, i;

	new = (void *)my_malloc(number * size);
	if (new) {
		s4 = align(number * size) << 2;
		for (i = 0; i < s4; i++) {
			new[i] = 0;
		}
	}		
	return (void *)new;
}

void *my_realloc(void *p, int size) {

	int s;
	meta block, new;
	void *newp;

	if (!p)	return(my_malloc(size));	 
	if (valid_ptr(p)) {
		s = align(size);
		block = get_block(p);
		if (block->size >= s) {
			if (block->size - s  >= (META_SIZE * 4))
				split_block(block, s);
		} else {
			if (block->next && block->next->free && block->size + META_SIZE * 4 + block->next->size >= s) {
			fusion(block);
			if (block->size - s  >= (META_SIZE * 4))
				split_block(block, s);
		} else {
			newp = my_malloc(s);
			if (!newp)	return NULL;
			new = get_block(newp);
			copy_block(block, new);
			free(p);
			return newp;
		}
		}
	return (p);
	}
	return NULL;
}

void copy_block(meta src, meta dst) {

	int *sdata, *ddata;
	int i;
	sdata = src->ptr;
	ddata = dst->ptr;
	for (i = 0; i * 4 < src->size && i * 4 < dst->size; i++ )
		ddata[i] = sdata[i];
}





















