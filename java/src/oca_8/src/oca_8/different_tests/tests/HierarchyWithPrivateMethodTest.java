package oca_8.different_tests.tests;

public class HierarchyWithPrivateMethodTest {

    private void method() {
        System.out.println("base");         //  1
    }

    public static void main(String[] args) {

        Derived derived = new Derived();
        derived.method();        // 2

        HierarchyWithPrivateMethodTest base = new Derived();
        base.method();
    }
}

class Derived extends HierarchyWithPrivateMethodTest {
    void method() {
        System.out.println("derived");      // 2
    }
}