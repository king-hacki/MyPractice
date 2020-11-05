package tests;

import java.lang.reflect.Method;
import java.util.*;

public class TreeSetWithoutComparator {
    public static void main(String[] args) throws NoSuchMethodException {

        Set<Plant> plants = new TreeSet<>();

        plants.add(new Plant("Rosa"));
        plants.add(new Plant("Tulpan"));
        plants.add(new Plant("Orxideya"));

        System.out.println(plants);

        Method m = TreeSetWithoutComparator.class.getMethod("main", String[].class);
        System.out.println(m.getName());
        System.out.println(m.getParameterCount());


    }
}

class Plant {
    private String name;
    public Plant(String name) {
        this.name = name;
    }
}
