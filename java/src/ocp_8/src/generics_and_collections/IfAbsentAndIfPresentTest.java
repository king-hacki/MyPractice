package generics_and_collections;

import java.util.*;
import java.util.function.BiFunction;

public class IfAbsentAndIfPresentTest<T> {
    
    public static void main(String[] args) {

        Map<String, String> favorites = new HashMap<>();

        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "null");

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        System.out.println(favorites);
        favorites.computeIfPresent("Tom", (s1, s2) -> s1 + "hi" + s2);
        System.out.println(favorites);

    }
    
    void l(List<?> test) {
        T t = null;
        System.out.println(t.toString());
    }

}
