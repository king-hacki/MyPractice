package generics_and_collections;

import java.util.Arrays;
import java.util.List;

public class FromArrayToList {

    public static void main(String[] args) {

        String [] array = { "gerbil", "mouse" };
        List<String> list = Arrays.asList(array);
        list.set(1, "test");
        array[0] = "new";

        System.out.println("List : " + list);
        System.out.println("Arrays : " + Arrays.toString(array));

        list.remove(1);     //  UnsupportedOperationException
        System.out.println("List : " + list);

    }

}


