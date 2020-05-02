package item_31_bounded_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodBoundWildCard {


    private static  <T> T method1(List<T> list) {
        return list.get(0);
    }

    private static  <T extends Number> T method2(List<? super T> list) {
        return (T)list.get(0);
    }

    private static <T extends Comparable<? super T>> T max (List <? extends T> list) {
        return list.get(0);
    }

    public static void swap(List<?> list, int i, int j) {
//    list.set(i, list.set(j, list.get(i)));            //  The problem is that the type of list is List<?>,
                                                        // and I can’t put any value except null into a List<?>

        swapHelper(list, i, j);                         //  The swapHelper method knows that list is a List<E>.
                                                        // Therefore, it knows that any value it gets out of this list is of type E
                                                        // and that it’s safe to put any value of type E into the list
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }


    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(Arrays.asList("First", "Two"));
        List<Object> objects = new ArrayList<>(Arrays.asList("First", "Two"));
        List<Number> numbers = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2));
        List<Animal> animals = new ArrayList<>(Arrays.asList(new Animal("Predators"), new Animal("Rodents")));
        List<Dog> dogs = new ArrayList<>(Arrays.asList(new Dog("Predators", "Mark"), new Dog("Predators", "Luffi")));

        System.out.println(method1(strings));
        System.out.println(method1(numbers));
        System.out.println(method1(animals));
        System.out.println(method1(dogs));

        System.out.println(method2(integers));
        System.out.println(method2(objects));

        System.out.println(max(Arrays.asList(
                new Animal("Wtf"),
                new Dog("Wtf", "Dog"),
                new Insect())));
    }

}

class Animal implements Comparable<Object> {


    String family;

    public Animal() {}

    public Animal(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Dog extends Animal {

    String name;

    public Dog() {}

    public Dog(String family, String name) {
        super(family);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Insect implements Comparable<Object> {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}