package item_29_favor_generic_type;

import java.util.ArrayList;
import java.util.List;

public class GenericStackRun {

    public static void main(String[] args) {

        String [] test =  {"first", "second", "third", "forth"};



        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Mark", 1));
        dogs.add(new Dog("Susan", 5));

        GenericStack<Dog> stack = new GenericStack<>();
        for (Dog dog : dogs)
            stack.push(dog);
        while (!stack.isEmpty())
            System.out.println(stack.pop().id);

        GenericStack<String> stack1 = new GenericStack<>();
        for (String word : test)
            stack1.push(word);
        while (!stack1.isEmpty())
            System.out.println(stack1.pop().toUpperCase());
    }
}

class Dog {

    String name;
    int id;

    public Dog(String name, int id) {
        this.name = name;
        this.id = id;
    }
}