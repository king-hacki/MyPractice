package oca_8.different_tests.Boyarskyi;

public class Bird {
    public static void main(String[] args) {
        Bird bird = new Pelican();
        bird.fly();

    }
    private void fly() {
        System.out.println("Bird can fly");
    }
}
class Pelican extends Bird {
    protected void fly() {
        System.out.println("Pelican can't fly");
    }
}
