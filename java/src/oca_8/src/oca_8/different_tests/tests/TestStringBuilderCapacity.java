package oca_8.different_tests.tests;

import java.util.ArrayList;
import java.util.Arrays;

public class TestStringBuilderCapacity {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(32);

        System.out.println("capacity : " + stringBuilder.capacity());
        System.out.println("length : " + stringBuilder.length());

        stringBuilder.append("some very very very long string to StringBuilder");

        System.out.println("capacity : " + stringBuilder.capacity());
        System.out.println("length : " + stringBuilder.length());

    }
}
