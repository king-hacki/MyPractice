package oca_8.strings_arrays_arrayList_calendar_lambda;

public class ArraysTest {

    public static void main(String[] args) {

        int [] i = new int[2];
        long [] l = new long[2];

//        i = l;        CE
//        l = i;        CE

        String [] s1 = new String[2];
        Object [] o1 = new String[2];

        String [] s2 = new String[2];
        Object [] o2 = new Object[2];

//        s2 = (String[]) o2;       //  ClassCastException
        s2 = (String [])o1;         //  OK because at RunTime o1 is new String[2]
    }
}
