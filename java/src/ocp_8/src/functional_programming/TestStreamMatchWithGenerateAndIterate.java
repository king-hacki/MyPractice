package functional_programming;

import java.util.OptionalLong;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamMatchWithGenerateAndIterate {

    public static void main(String[] args) {

        Predicate<String> stringSupplier = s -> s.startsWith("s");
        Stream<String> stream = Stream.generate(() -> "smth");
//        boolean s1 = stream.allMatch(stringSupplier);       //    Infinity iteration
//        boolean s2 = stream.anyMatch(stringSupplier);       //    true
//        boolean s3 = stream.noneMatch(stringSupplier);      //    false

        Predicate<String> stringSupplier2 = s -> s.length() > 3;
        Stream<String> stream2 = Stream.iterate("-", s -> s + s);
        boolean s4 = stream2.allMatch(stringSupplier2);         //  false
        boolean s5 = stream2.anyMatch(stringSupplier2);         //    true
        boolean s6 = stream2.noneMatch(stringSupplier2);        //    false

    }

}
