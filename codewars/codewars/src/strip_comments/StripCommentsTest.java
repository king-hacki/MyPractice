package strip_comments;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StripCommentsTest {

    @Test
    public void stripComments() {

        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );

        assertEquals(
                "a\n" +
                        " b\n" +
                        "c",
                StripComments.stripComments( "a \n" +
                        " b \n" +
                        "c ", new String[] { "#", "$" } )
        );

    }

    @Test
    public void stripComments2() {

        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments2( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments2( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );

    }
}
