package generics_and_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestBinarySearch<R> {

    public static void main(String[] args) {

        Comparator<Integer> c = Comparator.comparingInt(o -> o);
        List<Integer> list = Arrays.asList(5, 4, 7, 1);
        list.sort(c);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 1));
        
    }

}

class R {}
