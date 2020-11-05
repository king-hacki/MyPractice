package oca_8.soft;

public class Appl3 {
    public static void main(String[] args) {
        AA aa = new CC();
        aa.m1();
    }
}

interface AA {
    void m1();
}
interface BB extends AA {
    default void m1() {
        System.out.println("B");
    }
}
class CC implements AA, BB {}