package functional_programming;

import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamPipeline {

    public static void main(String[] args) {

        Stream<Integer> testStream = Stream.of(1, 2, 3, 4, 5, 6);
        int multiple = testStream.reduce(1, (v1 ,v2) -> v1 * v2);

        IntStream intTestStream = IntStream.of(1, 2, 3, 4, 5, 6);
        int multiple2 = intTestStream.reduce(1, (x, y) -> x * y);
        System.out.println(multiple);
        System.out.println(multiple2);
    }

}
