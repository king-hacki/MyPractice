package oca_8.flow_control_and_exceptions;

public class LoopTest {

    public static void main(String[] args) {

        int i;
        int [] array = {1, 2};
        Object [] o = {new Cat(), new Dog()};
//        for (i : array) {}   CE because i is already is
//        for (Dog d : o) {}   CE d must be object Compile time check
    }

}

class Dog {}
class Cat {}