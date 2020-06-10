package oca_8.different_tests.practice_test_1;

public class TestClass {
    public static void main(String args[]){
        boolean b = false;
        int i = 1;
        do{
            i++;
        } while (b = !b);
        System.out.println( i );
    }
}
