package oca_8.object_orientation;

public class DefaultMethodTest {
    public static void main(String[] args) {
        Test2A test2A = new Test2A();
        TestA testA = new TestA();
        A a2 = new Test2A();
        A a = new TestA();
        test2A.def();           //  default interface A
        testA.def();            //  default class TestA
        a2.def();               //  default interface A
        a.def();                //  default class TestA
    }
}


interface A {
     default void def() {
        System.out.println("default interface A");
    }
}
class TestA implements A {
    @Override
    public void def() {
        System.out.println("default class TestA");
    }
}
class Test2A implements A { }
