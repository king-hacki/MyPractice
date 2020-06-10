package oca_8.flow_control_and_exceptions;

import java.io.IOException;

public class TestSwitch {

    public static void main(String[] args) {
        final int x = 2;
        final int z = 1;
        int y = 5;

        switch (10) {
            case z:
            case x:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + 1);
        }

        byte g = 2;
        switch (g) {
            case 23:
            case (byte) 200:
        }

        switch (1) {
            case 1:
            default: System.out.println("default");
        }

    }

}
