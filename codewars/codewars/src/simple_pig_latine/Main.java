package simple_pig_latine;

/*
    Move the first letter of each word to the end of it, then add "ay" to the end of the word.
    Leave punctuation marks untouched.

    Examples:
        pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
        pigIt('Hello world !');     // elloHay orldway !

 */


import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(PigLatin.mySolution("  ! Hello world   "));
        System.out.println(PigLatin.bestSolution("  ! Hello world   "));
    }
}

class PigLatin {

    public static String mySolution(String str) {
        return Arrays.stream(str.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .map(word -> !word.matches("\\p{Punct}") ? " " + word.substring(1) + word.substring(0, 1) + "ay" : " " + word)
                .collect(Collectors.joining())
                .substring(1);
    }


    /// very interesting using replace
    public static String bestSolution(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

}