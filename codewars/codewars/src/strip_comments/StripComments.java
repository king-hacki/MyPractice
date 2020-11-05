package strip_comments;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

public class StripComments {


    public static String stripComments(String text, String[] commentSymbols) {
        return text.lines()
                .map(line -> {
                    for (String symbol : commentSymbols)
                        if (line.contains(symbol))
                            return line.substring(0, line.indexOf(symbol));
                    return line;
                })
                .map(String::stripTrailing)
                .collect(joining("\n"));
    }

    public static String stripComments2(String text, String[] commentSymbols) {
        return text.lines()
                .map(line -> line.substring(0, Arrays.stream(commentSymbols)
                        .mapToInt(line::indexOf)
                        .filter(i -> i != -1)
                        .min()
                        .orElse(line.length())))
                .map(String::stripTrailing)
                .collect(joining("\n"));
    }

}
