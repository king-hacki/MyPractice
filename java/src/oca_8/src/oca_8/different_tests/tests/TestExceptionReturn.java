package oca_8.different_tests.tests;

import java.io.IOException;

public class TestExceptionReturn {
    public static void main(String[] args) {
        System.out.println(test());
    }
    static int test () {
        try {
            System.out.println(1 / 0);
            System.out.println("returned");
        } catch (ArithmeticException arithmeticException) {
            System.out.println("catch");
            return 1;
        } finally {
            System.out.println("finally");
        }
        return 2;
    }
}
