package oca_8.strings_arrays_arrayList_calendar_lambda;

import java.util.function.Predicate;

public class LambdaTest {

    void go(Predicate<LambdaTest> predicate) {
        System.out.println(predicate.test(new LambdaTest()) ? "true" : "false");
    }

    static int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {

        System.out.println(0x11fe);

        LambdaTest lambdaTest = new LambdaTest();

        //  ======  LEGAL   ======  //
        lambdaTest.go(x -> true);
        lambdaTest.go(x -> {
            return add(2, 1) > 5;
        });
        lambdaTest.go((LambdaTest l) -> {
            int y = 5;
            return add(1, 2) > y;
        });
        lambdaTest.go(x -> add(1, 2) > 4);
    }
}

class SubLambdaTest extends LambdaTest {}

