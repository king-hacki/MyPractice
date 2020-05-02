package item_31_bounded_wildcards;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> set1 = Set.of("Hash", "Test");
        Set<Number> set2 = Set.of(1, 2);        //  OK
        Set<Integer> set3 = Set.of(1, 2);       //  OK
//        TestProvider.add(set1);                   CE
        TestProvider.add(set3);
//        TestConsumer.add(set3);                   CE
        Set<Object> set4 = Set.of(1, 2);
        TestConsumer.add(set4);                 //  OK

//        Set<Integer> set = TestExplicitTypeArgument.set(set2);    can't get Integer because return Number

    }

}

class TestProvider {
    static void add(Set<? extends Number> set) {
        System.out.println(set);
    }
}

class TestConsumer {
    static void add(Set<? super Number> set) {
        System.out.println(set);
    }
}

class TestExplicitTypeArgument {
    static <T> Set<T> set(Set<? extends T> s) {
//        return s;     CE want Set<E>
        return new HashSet<>(s);
    }

    //  reworked union from item: 30
    static <T> Set<T> union(Set<? extends T> s1, Set<? extends T> s2, Set<? extends T> s3) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);
        result.addAll(s3);
        return result;
    }
}