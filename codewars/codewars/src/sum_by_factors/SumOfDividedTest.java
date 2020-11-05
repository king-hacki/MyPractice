package sum_by_factors;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static sum_by_factors.SumOfDivided.sumOfDivided;

public class SumOfDividedTest {

    @Test
    public void testOne() {
        int[] lst = new int[] {12, 15};
        assertEquals("(2 12)(3 27)(5 15)", sumOfDivided(lst));
    }

    @Test
    public void prime() {
        sumOfDivided(new int[] {12, 15});
    }

}
