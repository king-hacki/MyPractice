package oca_8.different_tests.tests;

public class ExceptionWithPolimorphism {
    public static void main(String[] args) {
        Base2 base2 = new Derived2();
//        base2.method();       DON'T COMPILE
    }
}

class Base2 {
    void method() throws Exception {
        System.out.println("base");
    }
}

class Derived2 extends Base2 {
    @Override
    void method()  {
        System.out.println("derived");
    }
}
