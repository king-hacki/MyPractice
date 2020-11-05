package exceptions_and_assertions;

public class TestAutoCloseableWithLambda {

    public static void main(String[] args) {

        try (AutoCloseable auto = () -> {
            System.out.println("close");
            throw new Exception();
        }) {
            System.out.println("in try with resource");
        } catch (Exception e) {
            System.out.println("in exception");
        }

    }

}
