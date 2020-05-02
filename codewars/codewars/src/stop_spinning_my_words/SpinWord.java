package stop_spinning_my_words;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SpinWord {

        public static void main(String[] args) {

                System.out.println(new SpinWord().spinWords("the application, program test"));
                }

        public String spinWords(String text) {

                //	find other solution
                return Arrays.stream(text.split(" "))
                        .map(i -> i.length() >= 5 ? new StringBuilder(i).reverse().toString() : i)
                        .collect(Collectors.joining(" "));


                //	My work
        /*		List<String> words = Arrays.asList(text.split(" "));

                IntStream
                    .range(0, words.size())
                    .filter(index -> words.get(index).length() >= 5)
                    .forEach(index -> {
                        String reversedWordToReplace = SpinWord.reverseSpring(words.get(index));
                        words.set(index, reversedWordToReplace);
                    });

                String returnedString = String.join(" ", words);

                return returnedString;
            }

            public static String reverseSpring(String input) {

                char[] in = input.toCharArray();
                int begin = 0;
                int end = in.length - 1;
                char temp;

                while(end > begin) {

                    temp = in[begin];
                    in[begin] = in[end];
                    in[end] = temp;
                    end--;
                    begin++;

                }

                return new String(in);
        */
        }
}
