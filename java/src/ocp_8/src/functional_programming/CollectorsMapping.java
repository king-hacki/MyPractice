package functional_programming;


import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.*;

public class CollectorsMapping {

    public static void main(String[] args) {

//        Stream<String> stream = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Long> map1 = stream.collect(
//                groupingBy(String::length, counting()));
//        System.out.println(map1); // {5=2, 6=1}
//
//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Optional<Character>> map = ohMy.collect(
//                groupingBy(String::length, mapping(
//                    s -> s.charAt(0),
//                    minBy(naturalOrder()))));
//        System.out.println(map);        // {5=Optional[b], 6=Optional[t]}

    }

}
