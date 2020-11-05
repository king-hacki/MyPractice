package exceptions_and_assertions;

import java.sql.SQLException;

public class TestErrorCheckingByHierarch {

    static void testA() {
        throw new A();
    }

    static void testB() {
        throw new B();
    }

    public static void main(String[] args) {
        testA();
        testB();
    }

}

class A extends Error {}
class B extends A {}
