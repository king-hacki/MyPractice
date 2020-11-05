package tests;

public class InterfacesWithSameDefault {
}

interface CanWalk {
    default void walk() {
        System.out.println("CanWalk");
    }
}

interface CanRun {
    default void walk(String s) {
        System.out.println("CanRun");
    }
}

interface CanSprint extends CanWalk, CanRun {

}

class Man implements CanRun, CanWalk {

}