package oca_8.object_orientation;

public class TestBlocks {

    static int [] a = new int[3];
//    static {a[3] = 5;}        RE  java.lang.ExceptionInInitializerError Caused by: java.lang.ArrayIndexOutOfBoundsException:
//    {a[3] = 5;}               RE  Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:

    public static void main(String[] args) {
        TestBlocks testBlocks = new TestBlocks();
    }
}

interface T {
    default void m() {}
}
class AA implements T {
    {
        T.super.m();

    }
}