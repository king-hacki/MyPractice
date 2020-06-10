package oca_8.different_tests.practice_test_2;

import java.io.IOException;
import java.sql.SQLException;

public class Test_54_exception {
    public static void main(String[] args) throws Exception {
        
        try {

            if (Math.random() > 0.5)
                throw new IOException();
            else
                throw new SQLException();

        } catch (IOException e){
            System.out.println("catch IOException");
            throw new SQLException();
        } catch(SQLException e) {
            System.out.println("catch SQLException");
            throw new InstantiationException();
        } finally {
            System.out.println("in finally");
            throw new CloneNotSupportedException();
        }
    }
}
