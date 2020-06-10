package oca_8.testsSoftServeMarafonCourses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test5 {

    static void print(Object o) {
        System.out.println("Object");
    }

    static void print(Person o) {
        System.out.println("Object");
    }

    static void print(Employee o) {
        System.out.println("Object");
    }

    public static void main(String[] args) {

        Object c  = new  SpecialEmployee();
        print(c);

    }

}

class Person {}
class Employee extends Person {}
class SpecialEmployee extends Employee {}
