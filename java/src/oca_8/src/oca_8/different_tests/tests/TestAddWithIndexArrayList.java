package oca_8.different_tests.tests;

import java.util.ArrayList;

public class TestAddWithIndexArrayList {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>(10);
        stringArrayList.add("1");
        stringArrayList.add(5, "2");
        System.out.println(stringArrayList);
    }
}
