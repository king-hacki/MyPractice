package snail;


/*
    Given an n x n array, return the array elements arranged
    from outermost elements to the middle element, traveling clockwise.
    For better understanding, please follow the numbers of the next array consecutively:
    array = [[1,2,3],
             [8,9,4],
             [7,6,5]]
    snail(array) #=> [1,2,3,4,5,6,7,8,9]
 */

import java.util.Arrays;

public class Snail {

    public static int[] snail(int [][] array) {

        int [] s = new int[array.length * array.length];

        int a = 0;
        int i, j = 0;
        int h = 2;
        for (int k = 0; k < s.length; k++) {
            if (h == 2) {
                if (a++ < array.length) {

                }
            }
        }

        return s;
    }

    public static void main(String[] args) {

        int [][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        snail(array);
    }
}

