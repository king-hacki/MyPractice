package oca_8.soft;


class A {
    private void m1() {
        System.out.println("A_m1");
    }

    public void m2() {
        System.out.println("A_m2");
        m1();
    }
}

class B extends A {
    public void m1() {
        System.out.println("B_m1");
    }
}

public class Appl2 {
    public static void main(String[] args) {
        B a = new B();
        a.m2();
//        a.m1();
    }
}
