package functional_programming;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestPeek {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("test");
        Consumer<String> consumer = System.out::println;
        stringStream
                .peek(consumer)
                .peek(consumer)
                .forEach(consumer);

    }

}
