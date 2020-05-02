package item_29_favor_generic_type;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/*
    Writing own generic type:
        1) first generifying a class is to add one or more type parameters to its declaration
        2) The next step is to replace all the uses of the type Object with the appropriate
           type parameter and then try to compile the resulting program will cause CE (line 21)
           because can't create array with no non-reifiable type
           Solutions:
                1) cast to generic type line 24
                2)
 */

public class GenericStack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];    //    supress this

    }
    public void push(E e) {
        ensureCapacity(); elements[size++] = e;
    }

    public E pop() { if (size == 0)
        throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }


}
