package highest_scoring_word;

import java.util.Arrays;
import java.util.Comparator;


public class HighScore {

    public static void main(String[] args) {
        System.out.println(MyWork.high("some test"));
        System.out.println(MorePleasantSolution.high("some test"));
    }
}

class MorePleasantSolution {
    static String high(String text) {
        //  geniously
        return Arrays.stream(text.split(" ")).max(Comparator.comparingInt(a -> a.chars().map(i -> i - 96).sum())).orElseThrow();
    }
}

class MyWork {
    static String high(String text) {
        return Arrays.stream(text.split(" ")).max(Comparator.comparingInt(MyWork::count)).orElseThrow();
    }

     static int count(String s) {
        int count = 0;
        for (char c : s.toCharArray()) count += c - 96;
        System.out.println(s + " : " + count);
        return count;
    }
}
