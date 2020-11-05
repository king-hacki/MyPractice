package sum_by_factors;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.math.BigInteger.TWO;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.iterate;

public class SumOfDivided {

    public static String sumOfDivided(int[] numbers) {
        stream(numbers)
                .mapToObj(number -> iterate(TWO, bigInteger -> bigInteger.intValue() <= number, BigInteger::nextProbablePrime)
                        .map(BigInteger::intValue)
                        .filter(prime -> number % prime == 0)
                ).flatMapToInt(streamOfPrimes -> streamOfPrimes.mapToInt(Integer::intValue))
                .distinct()
                .peek(System.out::println)
                .collect(toMap(
                        Function.identity(),
                        prime -> stream(numbers).
                                filter(number -> number % (int)prime == 0)
                                .sum(),
                        Integer::sum
                ));
        return null;
    }


}
