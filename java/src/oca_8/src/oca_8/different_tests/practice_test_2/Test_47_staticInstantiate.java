package oca_8.different_tests.practice_test_2;

public class Test_47_staticInstantiate {

    public static void main(String[] args) throws Exception {
        System.out.println(Sub.finalTest);
        System.out.println(Sub.id);
        System.out.println(Sub.test);
    }
}
class Super {
    static String id = "qbank";
}

class Sub extends Super {
    final static String finalTest = "finalTest";
    static String test = "test";
    static {
        System.out.println("In Sub");
    }
}
