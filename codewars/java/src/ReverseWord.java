package src;

import java.util.*;

class ReverseWord {

    public static void main (String [] args) {
        
        System.out.println("[+] " + reverseWords("some text to test"));
        
    }
    
    public static String reverseWords(final String original) {
     
        String [] words = original.split(" ");
        
        StringBuilder word = new StringBuilder();
        StringBuilder text = new StringBuilder();
        
        for (String w : words) {
            word.append(w);
            text.append(word.reverse());
            text.append(" ");
            word = new StringBuilder();
        }
        
        return text.toString();
    }
}
