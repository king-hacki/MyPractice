package oca_8.testsSoftServeMarafonCourses;

public class Test2 {

    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.str);
        System.out.println(parent.m());
    }
}

class Parent {
    protected String str = "Parent";
    public String m() {
        return str;
    }
}

class Child extends Parent {
    String str = "Child";
    public String m() {
        return str;
    }
}