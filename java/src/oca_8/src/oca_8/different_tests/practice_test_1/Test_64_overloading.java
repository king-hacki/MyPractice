package oca_8.different_tests.practice_test_1;

public class Test_64_overloading {

    static void probe(int... x) { System.out.println("In ..."); }           //1
    static void probe(Integer x) { System.out.println("In Integer"); }      //2
    static void probe(long x) { System.out.println("In long"); }            //3
    static void probe(Long x) { System.out.println("In LONG"); }            //4

    public static void main(String[] args) {
        Integer a = 4;
        int b = 4;
        probe(a);
        probe((long) a);
        probe(b);
    }
}
