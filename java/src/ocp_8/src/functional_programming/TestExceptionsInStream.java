package functional_programming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TestExceptionsInStream {

    public static void main(String[] args) {

//        ExceptionCaseStudy.create().stream().count();                             CE
//        Supplier<List<String>> listSupplier = ExceptionCaseStudy::create;         CE
        Supplier<List<String>> listSupplier = () -> {
            try {
                return ExceptionCaseStudy.create();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };

        Supplier<List<String>> listSupplierBetterApproach = ExceptionCaseStudy::saveCreate;
    }

}

class ExceptionCaseStudy {
    static List<String> create() throws IOException {
        throw new IOException();
    }

    static List<String> saveCreate() {
        try {
            return create();
        } catch (IOException e) {
            return null;
        }
    }
}
