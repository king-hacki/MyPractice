package src;

import java.util.*;

class ReverseWord {

    public static void main (String [] args) {
        
        System.out.println("[+] " + reverseWords("          "));
        
    }
    
    public static String reverseWords(final String original) {
        String ret = "";
        String [] words = original.split("\\s");
        if(words.length == 0)   return original;
        for (String s : words)
            if (!(s == words[words.length - 1]))
                ret += new StringBuilder(s).reverse().toString() + " ";
            else
                ret += new StringBuilder(s).reverse().toString();
        return ret;
    }
}

