package item_30_favor_generic_method;

import java.util.HashSet;
import java.util.Set;

class Dog {}
public class Main {
    public static void main(String[] args) {

        Set<String> s1 = Set.of("Tom", "Larry");
        Set<Dog> s2 = Set.of(new Dog(), new Dog());
        Set<Number> se = Set.of(1, 2);
        Set<String> s3 = SimpleMethod.union(s1, s2, se);
        System.out.println(s3);

//        Set<String> s4 = GenericSimpleMethod.union(s1, s2, se);

    }
}
class SimpleMethod {
    //  very bad unacceptable because can accept different type
    static Set union(Set s1, Set s2, Set s3) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        result.addAll(s3);
        return result;
    }
}

class GenericSimpleMethod {
    static <T> Set<T> union(Set<T> s1, Set<T> s2, Set<T> s3) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);
        result.addAll(s3);
        return result;
    }
}


