package exceptions_and_assertions;

import java.sql.SQLException;

public class SuppressedException implements AutoCloseable {

    public static void main(String[] args) {


        try (SuppressedException se = new SuppressedException()) {
            System.out.println("IN TRY BLOCK");
            throw new Exception("FROM TRY");
        } catch (Exception e) {
            System.out.println(e.getMessage());             //  don't see FROM CLOSE when close FROM TRY print
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage());         //  now we see exception from close FROM CLOSE print
        }
    }

    @Override
    public void close() throws Exception {
        throw new Exception("FROM CLOSE");
    }
}
