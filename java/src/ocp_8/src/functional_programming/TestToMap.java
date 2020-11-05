package functional_programming;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestToMap {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map1 = stream
                .collect(toMap(
                        s -> s,
                        String::length
                ));
        System.out.println(map1);       //  {lions=5, bears=5, tigers=6}

        stream = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map2 = stream
                .collect(toMap(
                        String::length,
                        List::of,
                        (s1, s2) -> List.of(s1.toString(), s2.toString())
                ));
        System.out.println(map2);       //  {5=lions, bears, 6=tigers}

    }

}
