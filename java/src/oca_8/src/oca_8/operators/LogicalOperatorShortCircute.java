package oca_8.operators;

public class LogicalOperatorShortCircute {

    public static void main(String[] args) {

        int x = 5;
        int y = 5;

        if (++x > 5 || ++x > 6) System.out.println(x);  //  6
        if (++y > 5 | ++y > 6) System.out.println(y);   //  7

    }
}