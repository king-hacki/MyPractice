package oca_8.different_tests.Boyarskyi;

public class CallStaticByNullObject {

    static void method() {
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        CallStaticByNullObject c = null;
        c.method();
    }

}
