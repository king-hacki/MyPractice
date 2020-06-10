package oca_8.flow_control_and_exceptions;

class BadFoodException extends Exception {}

public class MyException {

    static void checkFood() throws BadFoodException {
        throw new BadFoodException();
    }

    public static void main(String[] args) {
        try {
            checkFood();
        } catch (BadFoodException e) {
            e.printStackTrace();
        } catch (Exception badFoodException) {
            badFoodException.printStackTrace();
        }
    }

}
