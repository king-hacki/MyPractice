package exceptions_and_assertions;

import java.io.IOException;

public class TestMultipleAndSingleCatchTogether {

    class CarCrash extends RuntimeException {}
    public static void main(String[] args) throws Exception {


        try {
            throw new IOException();
//        } catch (Exception | CarCrash e) {        CE CarCrash doesn't invoke
//            throw e;
        } catch (Exception a) {
            throw a;
        }
    }

}
