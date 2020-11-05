package functional_programming;

import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.Stream;

public class TestNonMatch {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.iterate(11, i -> i + 1);
        boolean b = stream.noneMatch(i -> i < 10);
        System.out.println(b);
    }

}
