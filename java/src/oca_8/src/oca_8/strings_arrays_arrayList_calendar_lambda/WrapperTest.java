package oca_8.strings_arrays_arrayList_calendar_lambda;

public class WrapperTest {
    public static void main(String[] args) {

        Integer i1 = 1000;
        Integer i2 = 1000;

        System.out.println(i1 == i2);           //  false
        System.out.println(i1.equals(i2));      //  true

        Integer i3 = 10;
        Integer i4 = 10;

        System.out.println(i3 == i4);           //  true
        System.out.println(i3.equals(i4));      //  true

    }
}
