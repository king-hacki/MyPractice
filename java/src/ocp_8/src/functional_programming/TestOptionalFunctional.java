package functional_programming;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class TestOptionalFunctional {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("4");
        Optional<Integer> result = optional.map(TestOptionalFunctional::calculate);
        //        Optional<Integer> result1 = optional.map(TestOptionalFunctional::calculateWithOptional);       CE
        Optional<Integer> result2 = optional.flatMap(TestOptionalFunctional::calculateWithOptional);         //  OK
    }

    static Integer calculate(String s) {
        return s.length();
    }

    static Optional<Integer> calculateWithOptional(String s) {
        return Optional.of(s.length());
    }

}

/* The problem is that calculator returns Optional<Integer>. The map() method adds another Optional,
    giving us Optional<Optional<Integer>>. Well, that&rsquo;s no good. The solution is to call flatMap() instead:

    This one works because flatMap removes the unnecessary layer. In other words, it flattens the result.
    Chaining calls to flatMap() is useful when you want to transform one Optional type to another.*/
