package oca_8.flow_control_and_exceptions;

import java.io.IOException;

public class HierarchyOfCatch {

    public static void main(String[] args) {

        try {
            throw new IOException();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
//        catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
    }

}
