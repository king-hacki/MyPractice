package item_44_use_functional_interfaces;

import java.util.Arrays;


public class Test {

    Object o;

    public static void main(String[] args) {

        int [] a = {1, 2, 3, 4, 5};
        int x = Arrays.stream(a).max().getAsInt();
        System.out.println(x);
    }
    
}


