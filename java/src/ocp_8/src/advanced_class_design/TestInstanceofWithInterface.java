package advanced_class_design;

public class TestInstanceofWithInterface {
    public static void main(String[] args) {

        System.out.println(new A() instanceof A);       //  true
        System.out.println(new A() instanceof B);       //  false
        System.out.println(new B() instanceof A);       //  true
//        System.out.println(new B() instanceof C);     CE
//        System.out.println(new A() instanceof C);     CE
        System.out.println(new B() instanceof I);       //  false
        System.out.println(new A() instanceof I);       //  false

    }
}

class A {}
class B extends A {}
class C {}
interface I {}
