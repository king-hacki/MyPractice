package oca_8.different_tests.practice_test_1;

public class Test_58_instanceof {

    public static void main(String[] args) {

        BB b = new BB();
        System.out.println((b instanceof AA) && !(b instanceof CC) && !(b instanceof DD));

    }

}

class AA {}
class BB extends AA {}
class CC extends BB {}
class DD extends CC {}

