package generics_and_collections;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcardTest {

    static void objectTestUnbound(List<Object> objectList) {
        for (Object o : objectList)
            System.out.println(o);
    }

    static void unboundTestUnbound(List<?> objectList) {
        for (Object o : objectList)     //  should be Object o
            System.out.println(o);
    }

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("test");

//        objectTestUnbound(stringList);        CE
        unboundTestUnbound(stringList);
    }

}


