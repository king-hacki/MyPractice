package item_48_use_caution_in_parallel_streams;

import java.math.BigInteger;
import java.util.stream.Stream;
import static java.math.BigInteger.*;

public class MersennePrimes {

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);      //  TWO - 2 from BigInteger
    }                                                                   //  nextProbablePrime - return first integer which is greater then this
}
