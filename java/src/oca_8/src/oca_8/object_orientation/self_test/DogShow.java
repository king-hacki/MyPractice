package oca_8.object_orientation.self_test;

class Dog {
    public void bark() {
        System.out.println("woof ");
    }
}
class Hound extends Dog {
    public void sniff() {
        System.out.println("sniff ");
    }
    @Override
    public void bark() {
        System.out.println("howl ");
    }
}
public class DogShow {
    public static void main(String[] args) {

        Hound h = (Hound) new Dog();    // RE ClassCast
        new DogShow().go();
    }
    void go() {
        new Hound().bark();
        new Hound().sniff();
        ((Dog) new Hound()).bark();
        ((Hound) new Dog()).sniff();        //  RE ClassCastException
//        ((Dog) new Hound()).sniff();      //  CE Dog doesn't have sniff()
    }
}
