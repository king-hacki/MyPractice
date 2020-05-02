package item_28_prefer_list_to_array;

import java.util.List;

//  why generic array creation is illegal
public class TestGenericArray {

    public static void main(String[] args) {
        /*


        List<String>[] stringList1 = new List<String>[1];       //  (1)
        List<Integer> stringList2 = List.of(42);                //  (2)
        Object [] objects = stringList1;                        //  (3)
        objects[0] = stringList2;                               //  (4)
        String s = stringList1[0].get(0);                       //  (5)



            Let’s pretend that line 1, which creates a generic array, is legal.
            Line 2 creates and initializes a List<Integer> containing a single element.
            Line 3 stores the List<String> array into an Object array variable, which is legal because arrays are covariant.
            Line 4 stores the List<Integer> into the sole element of the Object array,
            which succeeds because generics are implemented by erasure: the runtime type of a List<Integer> instance is simply List,
            and the runtime type of a List<String>[] instance is List[], so this assignment doesn’t generate an ArrayStoreException.
            Now we’re in trouble. We’ve stored a List<Integer> instance into an array that is declared to hold only List<String> instances.
            In line 5, we retrieve the sole element from the sole list in this array.
            The compiler automatically casts the retrieved element to String, but it’s an Integer,
            so we get a ClassCastException at runtime. In order to prevent this from happening,
            line 1 (which creates a generic array) must generate a compile-time error.

         */
    }
}

class Dog {}