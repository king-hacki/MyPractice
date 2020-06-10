package oca_8.flow_control_and_exceptions;

public class LabelTest2 {

    public static void main(String[] args) {
        outer:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.println("hello");
                    continue outer;
                }
                System.out.println("outer");
            }
        System.out.println("good by");
    }

}
