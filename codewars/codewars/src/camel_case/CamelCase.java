package camel_case;

import java.util.Arrays;
import java.util.stream.Collectors;


public class CamelCase {

    public static void main(String[] args) {

        String test = " Kwm wep pw pe";
        System.out.println(toCamelCaseLamda(test));

    }

    private static String toCamelCaseLamda(String text) {
        return Arrays.stream(text.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .findFirst()
                .map(word -> word.substring(0, 1).toLowerCase() + word.substring(1))
                .orElseThrow()
                .concat(Arrays.stream(text.split("\\s+"))
                        .filter(word -> !word.isEmpty())
                        .skip(1)
                        .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                        .collect(Collectors.joining(""))
                );

        }
}



