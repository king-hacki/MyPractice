package functional_programming;

import java.util.function.*;

public class TestDifferentFunctionalInterfaceFromTest {

    public static void main(String[] args) {

//        BiFunction<Integer, Double, Integer> test1 = (int i, double d) -> (int) (i + d);      CE
        BiFunction<Integer, Double, Integer> test2 = (Integer i, Double d) -> (int) (i + d);
        BiFunction<Integer, Double, Integer> test3 = (i, d) -> (int) (i + d);

//        IntFunction<Integer> test4 = (Integer f) -> f;            CE
        IntFunction<Integer> test4 =  f -> f;

        BooleanSupplier test5 = () -> true;

        ToDoubleBiFunction<Integer, Double> test6 = (Integer i, Double d) -> (double) d;

//        BinaryOperator<Long> test7 = (Integer i1, Integer i2) -> (long) (i1 + i2);        CE Because Long i1, i2 not Integer
        BinaryOperator<Long> test8 = (l1, l2) -> (long) l1.intValue();

        UnaryOperator<String> test9 = s -> s;
        test9.apply("test");

//        DoubleToIntFunction test10 = d -> d * 100;        CE
        DoubleToIntFunction test11 = d -> (int) (d * 100);

//        IntFunction<String> test12 = (Integer i) -> "" + i;   //  CE no Integer but int
        IntFunction<String> test12 = (int i) -> "" + i;
    }

}
