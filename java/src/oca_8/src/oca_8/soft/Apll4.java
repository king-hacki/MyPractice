package oca_8.soft;

public class Apll4 {

    static void m1(Dad a) {
        System.out.println("A");
    }

    static void m1(Son b) {
        System.out.println("B");
    }

    public static void main(String[] args) {
        m1(null);
    }

}

class Dad {}
class Son extends Dad {}
class Child extends Son {}


