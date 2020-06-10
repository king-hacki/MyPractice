package oca_8.assignments;

import java.util.ArrayList;
import java.util.Date;

public class TestGC {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total JVM memory: " + runtime.maxMemory());
        System.out.println("Before Memory = " + runtime.freeMemory());
        Date d = null;

        int a = 5;
        int x = 2147483647 * a;


        for (int i = 0; i < 10000; i++) {
            d = new Date();
            d = null;
        }

        System.out.println("After Memory = " + runtime.freeMemory());

        for (int i = 0; i < 100; i++) {
            runtime.gc();
            System.out.println("After GC Memory = " + runtime.freeMemory());
        }

    }

}
