package item_39_prefer_annot_to_naming;

public class Sample {

    @Test
    public static void m1() { }               // Test should pass public static void m2() { }

    @Test
    public static void m3() {                 // Test should fail
        throw new RuntimeException("Boom");
    }

    public static void m4() { }

    @Test
    public void m5() { }                      // INVALID USE: nonstatic method public static void m6() { }

    @Test
    public static void m7() {                 // Test should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() { }



    @ExceptionTest(ArithmeticException.class)
    public static void m9() {  // Test should pass
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m10() {  // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m11() { }  // Should fail (no exception)

}
