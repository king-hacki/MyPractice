package path_finder_reach_exit;

import java.util.Arrays;

public class ReachExit {


    static boolean pathFinder(String m) {

        String [] first = m.split("\n");
        char [][] maze = new char[first.length][first.length];

        for (int i = 0; i < first.length; i++)
            for (int j = 0; j < first.length; j++)
                maze[i][j] = first[i].charAt(j);





        display(maze);

        return false;
    }


    private static void display(char[][] a) {
        for (char[] chars : a) display(chars);
        System.out.println();
    }

    private static void display(char [] a) {
        System.out.print("\n{");
        for (char c : a) System.out.print(" " + c + " ");
        System.out.print("}");
    }

    private static void display(String [] a) {
        System.out.print("{");
        for (String c : a) System.out.print(" " + c + " ");
        System.out.print("}");
    }


    public static void main(String[] args) {
        pathFinder(
                "..X.\n"+
                "....\n"+
                "....\n"+
                ".XX.");
    }

}
