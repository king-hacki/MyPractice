package oca_8.different_tests.tests;

public class TestPolimorphism {
    int x;
    public static void main(String[] args) {

//        System.out.println(this.x);   CE can't use this in static context

        Dad d = new Son();
        Son s = (Son) d;        //   no RE because at runtime d = new Son()

        Dad d2 = new Dad();
        Son s2 = (Son) d2;      //  RE d2 = new Dad()
    }
}
class Dad { }
class Son extends Dad {}