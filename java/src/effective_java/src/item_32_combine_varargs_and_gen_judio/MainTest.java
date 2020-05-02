package item_32_combine_varargs_and_gen_judio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    @SafeVarargs
    //  Possible heap pollution from parameterized vararg type under testVarargsAndGeneric
    private static <T> void  testVarargsAndGeneric(T ... strings) {
        Arrays.stream(strings).forEach(System.out::println);
    }

    //  not safe 1) can't return parametrize varargs
    private static <T> T[]  dangerous1(T ... strings) {
       return strings;
    }

    //  not safe 2) can't change parametrize varargs
    private static <T> void  dangerous2(T ... strings) {
        strings[0] = (T) "Doesn't store anything";
    }

    // Safe method with a generic varargs parameter
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    // List as a typesafe alternative to a generic varargs parameter
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
           for (List<? extends T> list : lists)
                result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        testVarargsAndGeneric("Some", "test");
    }

}




