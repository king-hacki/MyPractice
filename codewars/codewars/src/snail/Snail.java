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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snail {

    public static void main(String[] args) {

//        int [][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] array = {{}};
        snail(array);
    }

    public static int[] snail(int [][] array) {
        if (array[0].length == 0) return new int[0];
        int [] s = new int[array.length * array.length];
        int a = array.length;
        int m = 1;
        int way = 1;
        int t = 0;
        int i = 0;
        int j = 0;
        for (int k = 0; k < s.length; k++, m++) {
            switch (way) {
                case 1:
                    if (a == m) {
                        m = 0;
                        way++;
                        s[k] = array[i++][j];
                        if (t == 0) {
                            t = 1;
                            a--;
                        } else t--;
                        break;
                    } else {
                        s[k] = array[i][j++];
                        break;
                    }
                case 2:
                    if (a == m) {
                        m = 0;
                        way++;
                        s[k] = array[i][j--];
                        if (t == 0) {
                            t = 1;
                            a--;
                        } else t--;
                        break;
                    } else {
                        s[k] = array[i++][j];
                        break;
                    }
                case 3:
                    if (a == m) {
                        m = 0;
                        way++;
                        s[k] = array[i--][j];
                        if (t == 0) {
                            t = 1;
                            a--;
                        } else t--;
                        break;
                    } else {
                        s[k] = array[i][j--];
                        break;
                    }
                case 4:
                    if (a == m) {
                        m = 0;
                        way = 1;
                        s[k] = array[i][j++];
                        if (t == 0) {
                            t = 1;
                            a--;
                        } else t--;
                        break;
                    } else {
                        s[k] = array[i--][j];
                        break;
                    }
            }
        }
        return s;
    }
}
