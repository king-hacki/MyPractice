package item_58_for$each;

public class Main {
    public static void main(String[] args) {

        Integer [] integers = {1, 2, 3, 4, 5};
        Dog [] dogs = {new Dog("Lucy"), new Dog("Kathy"), new Dog("John")};

        IterableClass<Integer> integerIterableClass = new IterableClass<>(integers);
        IterableClass<Dog> dogIterableClass = new IterableClass<>(dogs);

        for (Integer i : integerIterableClass)
            System.out.println(i);

        for (Dog d : dogIterableClass)
            System.out.println(d);
    }
}

class Dog {
    final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}