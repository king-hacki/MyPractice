package oca_8.different_tests.tests;

public class ExceptionWithPolimorphism {
    public static void main(String[] args) {
        Base2 base2 = new Derived2();
        Derived2 derived2 = new Derived2();
        derived2.method();
//        base2.method();       DON'T COMPILE
    }
}

class Base2 {
    void method() throws Exception {
        System.out.println("base");
    }
}

class Derived2 extends Base2 {
    void method()  {
        System.out.println("derived");
    }
}
