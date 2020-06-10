package item_52_overloading;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        System.out.println(set + " " + list);
        for (int i = 0; i < 3; i++) {
/*
            Removes the specified element from this set if it is present.
            More formally, removes an element {@code e} such that
            {@code Objects.equals(o, e)},
*/
            set.remove(i);
/*
            Removes the element at the specified position in this list.
            Shifts any subsequent elements to the left
*/
            list.remove(i);
        }
        System.out.println(set + " " + list);
    }
}
