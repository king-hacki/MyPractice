package exceptions_and_assertions;

import java.io.Closeable;
import java.io.IOException;

public class TestAutoClosable implements AutoCloseable {

    public static void main(String[] args)  {


        try (TestAutoClosable temp = new TestAutoClosable()) {
            System.out.println("open");
        } catch (Exception e ) {

        }

    }

    @Override
    public void close() throws Exception {
        System.out.println("closed");
    }
}

class TestCloseable implements Closeable {

    void test() {
        try (TestCloseable temp = new TestCloseable()) {

        } catch (IOException e) {

        }
    }

    @Override
    public void close() throws IOException {

    }
}
