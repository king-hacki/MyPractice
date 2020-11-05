package tests;

import java.util.ArrayList;
import java.util.List;

public class TestRemoveIf {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("3");
        list.removeIf(e -> e.length() > 2);

        System.out.println(list);
    }
}

