package oca_8.soft;

public class Appl5 {
    public static void main(String[] args) {
        AAA aaa = new CCC();
        aaa.m1();
    }
}

interface AAA {
    default void m1() {
        System.out.println("A");
        m2();
    }
    default void m2() {
        System.out.println("A");
    }
}

interface BBB extends AAA {
    default void m2() {
        System.out.println("B");
//        super.m2();       CE
        ((AAA)this).m2();
    }
}

class CCC implements BBB {}
