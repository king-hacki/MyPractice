package functional_programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestFlatMap {

    public static void main(String[] args) {

        List<Integer> list = IntStream.range(1, 6).boxed().collect(Collectors.toList());

        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
//        IntStream intStream = stream.mapToInt(i -> i);
        Map<Boolean, Map<Integer, String>> collect = stream.collect(Collectors.partitioningBy(
                i -> i > 3,
                Collectors.mapping(
                        i -> i * 10,
                        Collectors.toMap(
                                i -> i,
                                Object::toString,
                                String::concat
                        )
                )
        ));

        System.out.println("collect = " + collect);

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList();
        Stream.of(l1, l2, l3)
//                .map(x -> x + 1)
                .flatMap(Collection::stream)        //  Convert 3 lists to Stream<Object>
                .forEach(System.out::print);

    }

}
