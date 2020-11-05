package exceptions_and_assertions;

import java.io.IOException;
import java.sql.SQLException;

public class TestNewRethrow {

    static void test() throws SQLException, IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws IOException, SQLException {

        try {
            test();
        } catch (SQLException | IOException e) {
            System.out.println("e = " + e);
            throw e;
        }

    }

}
