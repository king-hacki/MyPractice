package find_two_fibonacci_number;

/*
    productFib(714) # should return (21, 34, true),
                # since F(8) = 21, F(9) = 34 and 714 = 21 * 34

    productFib(800) # should return (34, 55, false),
                    # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
    -----
    productFib(714) # should return [21, 34, true],
    productFib(800) # should return [34, 55, false],
    -----
    productFib(714) # should return {21, 34, 1},
    productFib(800) # should return {34, 55, 0},
    -----
    productFib(714) # should return {21, 34, true},
    productFib(800) # should return {34, 55, false},

 */

import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        Arrays.stream(ProdFib.productFib(4895)).forEach(System.out::println);
    }

}

class ProdFib {
    static long[] productFib(long b) {
        long p = 0;
        long c = 1;

        while (b > c * p) {
            long t = p;
            p += c;
            c = t;
        }
        return new long[] {c, p, b == c * p ? 1 : 0};
    }

}