package oca_8.different_tests.practice_test_1;

public class TestHierarchy {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();

//        b = (B)(I)a;     // RE because B doesn't have A
//        a = (I)b;         CE big I into smaller A

        A aa = (B)a;            //  RE
        A aa2 = (C)a;           //  RE
        A aa3 = (C)(I)a;        //  RE

        I i = (I) a;
        a.t();

        a = (B)(I) b;
        b.t();  //  B

        int x = ~3;
        System.out.println(x);

    }

}

interface I {
    default void t() {
        System.out.println("I");
    }
}
class A implements I {
    public void t() {
        System.out.println("A");
    }
}
class B extends A {
    public void t() {
        System.out.println("B");
    }
}
class C extends B {
    public void t() {
        System.out.println("C");
    }
}
