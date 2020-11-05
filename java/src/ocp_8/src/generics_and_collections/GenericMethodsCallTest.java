package generics_and_collections;

public class GenericMethodsCallTest {

    public static void main(String[] args) {
        GenericMethod.test();
        new GenericMethod().test2();
    }

}

class GenericMethod {
    static <T> void test() {}
    <T> void test2() {}
}
