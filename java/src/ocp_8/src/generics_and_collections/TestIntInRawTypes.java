package generics_and_collections;

import java.util.*;

public class TestIntInRawTypes {
    
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add(3);
//        for (String s : list)             CE can't use String in for-each with raw types
//            System.out.println(s);

        for (Object s : list)       //  only Object
            System.out.println(s);

        new TreeSet();
    }
}
