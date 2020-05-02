package type_information;


import java.util.Arrays;

class ForTest {

    Object object = new Object();
    StringBuilder stringBuilder = new StringBuilder();

    static class Member {}

}

public class TestTypeInformation {

    public static void main(String[] args) {

        System.out.println("canonical : " + ForTest.class.getCanonicalName());
        System.out.println("simple name : " + ForTest.class.getSimpleName());
        System.out.println("get all classes that are members : " + Arrays.toString(ForTest.class.getClasses()));
        System.out.println("to generic string : " + ForTest.class.toGenericString());


        try {
            Class.forName("ForTest");
        } catch (ClassNotFoundException e) {
            System.err.println("error");
        }
    }

}




