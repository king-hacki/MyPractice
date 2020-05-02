package item_18_composition_over_inehritence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Dog {

    final private String name;
    final private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        Dog dog1 = new Dog("Maks", 2);
        Dog dog2 = new Dog("Lukas", 4);

        List<Dog> dogList = new ArrayList<>(Arrays.asList(new Dog("Ken", 10), new Dog("Feig", 1)));

        DogHashSet<Dog> dogs = new DogHashSet<>(new HashSet<>());

        dogs.add(dog1);
        dogs.add(dog2);

        dogs.addAll(dogList);

        System.out.println("All Dogs : ");
        dogs.forEach(System.out::println);

        System.out.println("Count : " + dogs.getCount());

    }

    @Override
    public String toString() {
        return "\tDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


