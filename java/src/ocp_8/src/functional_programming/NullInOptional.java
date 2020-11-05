package functional_programming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NullInOptional {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of(null);      //  RE NoSuchElementException


        Optional o = Optional.empty();
        testNotGenericOptional(o);

        List l = new ArrayList();
        testNotGenericList(l);
        
    }

    private static void testNotGenericOptional(Optional<Exception> test) {}
    private static void testNotGenericList(List<Exception> test) {}

}
