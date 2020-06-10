package oca_8.different_tests.practice_test_2;

public class Test_4 {
    public static void main(String[] args) {

        boolean b1 = false;
        boolean b2 = false;

//        if (b2 != b1 = !b2) {         CE
        if (b2 = b2 != b1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        if (false) {
            System.out.println("x");
        } else {
            System.out.println("X");
        }
//        while (false) {
//            System.out.println("x");        //  CE
//        }

//        for (;false;) {
//            System.out.println("x");        //  CE
//        }
    }
}
