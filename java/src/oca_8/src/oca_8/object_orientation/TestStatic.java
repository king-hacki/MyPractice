package oca_8.object_orientation;

public class TestStatic {

    public static void main(String[] args) {
        B.method();
    }

}

class C {
    static void method() {
        System.out.println("Hi from C");
    }
}

class B extends C {

    static void method () {
        System.out.println("Hi from B");
    }
}
