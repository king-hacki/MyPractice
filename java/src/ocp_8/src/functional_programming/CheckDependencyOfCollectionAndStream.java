package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckDependencyOfCollectionAndStream {

    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        Optional<Integer> opt = list.stream().sorted().findFirst();
        System.out.println("opt.get() = " + opt.get());         //  1
        System.out.println("list.get(0) = " + list.get(0));     //  3
        
    }
    
}
