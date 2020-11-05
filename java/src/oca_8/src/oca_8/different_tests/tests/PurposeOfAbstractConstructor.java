package oca_8.different_tests.tests;

public class PurposeOfAbstractConstructor {
    public static void main(String[] args) {

//        Abstract err = new Abstract();       CE

        //  anonymous
        Abstract a = new Abstract("Anonymous abstract class created") {
            @Override
            void display() {
                System.out.println("Anonymous abstract class");
            }
        };

//        CheckForNewInAnonymous justCheck = new CheckForNewInAnonymous("smth") {}; CAN'T GIVE PARAM

        Abstract poli = new AbstractDerived("Derived class created");
        AbstractDerived abstractDerived = new AbstractDerived("Polymorphism class created");

        a.display();
        poli.display();
        abstractDerived.display();

        System.out.println(a.name);
        System.out.println(poli.name);
        System.out.println(abstractDerived.name);

    }
}

interface CheckForNewInAnonymous {}

abstract class Abstract {

    final String  name;

    Abstract(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    abstract void display();
}

class AbstractDerived extends Abstract {

    String name;

    AbstractDerived(String name) {
        super(name);
        this.name = "name";
    }

    @Override
    void display() {
        System.out.println("AbstractDerived");
    }
}

