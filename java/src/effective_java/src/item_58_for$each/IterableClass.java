package item_58_for$each;

import java.util.Iterator;

public class IterableClass<T> implements Iterable<T> {

    private T [] array;
    private int currentSize;

    public IterableClass(T[] array) {
        this.array = array;
        this.currentSize = array.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("don't support");
            }
        };
    }
}
