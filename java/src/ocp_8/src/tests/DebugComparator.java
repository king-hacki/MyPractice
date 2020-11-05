package tests;

import java.util.ArrayList;
import java.util.List;

public class DebugComparator {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("the");
        strings.add("comparator");
        strings.add("using debug");
        strings.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println(strings);
    }
}
