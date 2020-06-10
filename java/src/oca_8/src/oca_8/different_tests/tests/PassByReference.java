package oca_8.different_tests.tests;

public class PassByReference {

    int x = 1;

    public static void main(String[] args) {
        PassByReference reference  = new PassByReference(1);
        go(reference);
        System.out.println(reference.x);        //  2
    }

    public PassByReference(int x) {
        this.x = x;
    }

    static void go(PassByReference reference) {
        reference.x = 2;
    }
}
