package oca_8.different_tests.tests;

public class HierarchyTest {

    private void method() {
        System.out.println("base");         //  1
    }

    public static void main(String[] args) {

        Derived derived = new Derived();
        derived.method();        // 2

        HierarchyTest base = new Derived();
        base.method();
    }
}

class Derived extends HierarchyTest {
    void method() {
        System.out.println("derived");      // 2
    }
}