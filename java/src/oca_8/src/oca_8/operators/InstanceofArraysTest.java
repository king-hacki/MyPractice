package oca_8.operators;

public class InstanceofArraysTest {
    public static void main(String[] args) {
        Foo [] array = new Foo[0];
//        System.out.println(array instanceof Foo);         CE cannot cast Foo[] to Foo
    }
}

class Foo { }