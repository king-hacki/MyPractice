package src;

import java.lang.String;
import java.util.Arrays;


class Cezar { 

    public static void main(String [] args) {
        
        String [] out = new String[args.length];
        
        for (int i = 0 ;i < args.length; i++) {
            char [] word = args[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                if (word[j] == 'x') word[j] = 'a';
                else if (word[j] == 'y') word[j] = 'b';
                     else if (word[j] == 'z') word[j] = 'c';
                          else word[j] += 3;
            }
            out[i] = new String(word);
        }
        
        System.out.println("Input words : " + Arrays.toString(args));
        System.out.println("Cezar crypt : " + Arrays.toString(out));
        
    }
}