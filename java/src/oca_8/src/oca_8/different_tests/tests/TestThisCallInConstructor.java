package oca_8.different_tests.tests;

public class TestThisCallInConstructor {

    String name;

    public TestThisCallInConstructor() {
        this("name");
    }

    public TestThisCallInConstructor(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestThisCallInConstructor t = new TestThisCallInConstructor();
        System.out.println(t.name);
    }
}
