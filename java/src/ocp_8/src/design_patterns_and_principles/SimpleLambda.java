package design_patterns_and_principles;

@FunctionalInterface
interface CheckAnimal {
    boolean check(Animal animal);
}

@FunctionalInterface
interface DisplayAnimal {
    String display();
}

class Animal {
    private String spec;
    private boolean canHope;
    private boolean canSwim;

    public Animal() {}

    public Animal(String spec, boolean canHope, boolean canSwim) {
        this.spec = spec;
        this.canHope = canHope;
        this.canSwim = canSwim;
    }

    public boolean isCanHope() {
        return canHope;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "spec='" + spec + '\'' +
                '}';
    }
}

public class SimpleLambda {

    private static void printIfCanHope(Animal animal, CheckAnimal checkAnimal) {
        if (checkAnimal.check(animal))
            System.out.println(animal);
    }

    private static void displayAnimal(DisplayAnimal displayAnimal) {
        System.out.println(displayAnimal.display());
    }

    public static void main(String[] args) {
        printIfCanHope(new Animal("Fish", false, true), a -> a.isCanHope());
        printIfCanHope(new Animal("Kangaroo", true, false), a -> a.isCanHope());

        displayAnimal(() -> new Animal("Sniper", true, true).toString());
    }
}
