package oca_8.different_tests.tests;

public class MomentIncrement {
    public static void main(String[] args) {
        int p = 1;
        p = p++ + --p;
        System.out.println(p);
    }
}
