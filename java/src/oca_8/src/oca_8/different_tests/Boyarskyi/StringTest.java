package oca_8.different_tests.Boyarskyi;

import java.util.Arrays;
import java.util.Calendar;

public class StringTest {
    public static void main(String[] args) {
        String a = "hello";
        if ("hello" == a) System.out.println("1");
        a += false;
        a += 2;
        if ("hellofalse2" == a) System.out.println("2");
        if ("hellofalse2".equals(a)) System.out.println("3");
    }
}
