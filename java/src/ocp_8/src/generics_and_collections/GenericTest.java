package generics_and_collections;

import java.util.ArrayList;
import java.util.List;

class A {}
class B extends A { }
class C extends B { }


public class  GenericTest<T extends C> {

    public static void main(String[] args) {
//        List<? extends Exception> list = new ArrayList<T>();      T can't use in static context
    }

    public void method() {
        List<A> list = new ArrayList<A>();
        list.add(new A());
        list.add(new B());
    }



}
