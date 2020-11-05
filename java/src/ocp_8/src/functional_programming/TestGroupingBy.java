package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestGroupingBy {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map1 = stream.
                collect(groupingBy(String::length));
        System.out.println(map1);                        //  {5=[lions, bears], 6=[tigers]}

        stream = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map2 = stream.
                collect(partitioningBy(s -> s.length() <= 7));
        System.out.println(map2);                        //     {false=[], true=[lions, tigers, bears]}
    }

}
