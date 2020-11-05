package functional_programming;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForEachForIntStream {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("test1", "test2");
        stream.mapToInt(String::length).forEach(System.out::println);

        OptionalDouble test = OptionalDouble.empty();
        double t = test.getAsDouble();
        System.out.println(t);


    }

}
