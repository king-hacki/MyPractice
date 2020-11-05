package oca_8.different_tests.tests;

public class TwoDimArrayToOneObjectArrayTest {
    static int [][] array1;
    public static void main(String[] args) {

//        array1[1][1] = 3;        //  NullPointerException
        int [][] array = new int[2][2];
        Object [] objects = array;
        objects[1] = "x";
        System.out.println(array[1][1]);

        int [][] i1[], i2;
        i2 = new int[2][];

        String [] s = new String[2];
        System.out.println(s);      // [Ljava.lang.String;@5a39699c

        //  HI I am java 6, nice to meet you
        Object o1 = true;
        Object o2 = 3;
    }
}
