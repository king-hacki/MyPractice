package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");


        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        list.stream().forEach(System.out::println);
        stream.forEach(System.out::println);
    }

}
