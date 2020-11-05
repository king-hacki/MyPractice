package oca_8.different_tests.tests;

public class ImplementsInterfacesWithTheSameDefaultMethods {
    public static void main(String[] args) {

        Implementer implementer = new Implementer();
        implementer.def();

        A a = new Implementer();
        a.def();

        B b = new Implementer();
        b.def();

        A anonymous = new A(){
            public void def() {
                System.out.println("Anonymous def");
            }
        };

    }
}

interface A {
    default void def() {
        System.out.println("A");
    }
}

interface B {
    default void def() {
        System.out.println("B");
    }
}

interface C extends A, B {          //      must be def() implementation
    default void def() {
        System.out.println("interface C");
    }
}

class Implementer implements A, B {
    public void def() {
        System.out.println("Implementer");
    }
}

//abstract class AbstractImplementer implements A, B { }        CE need implement method def()

abstract class AbstractImplementer implements A, B {
    public abstract void def();
}