package sum_of_digits;


public class DigitsRoot {

    /**
     * Given n, take the sum of the digits of n. If that value has more than one digit,
     * continue reducing in this way until a single-digit number is produced.
     * This is only applicable to the natural numbers.
     *
     * @param n input number
     * @return the sum of digits
     */
    public static int digitsRoot(int n) {
        int s;
        do {
            s = 0;
            while (n != 0) {
                s += n % 10;
                n = n / 10;
            }
        } while ((n = s) >= 10);

        return s;
    }

    public static int digitsRootBestSolution(int n) {
        return --n % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(digitsRoot(456));
        System.out.println(digitsRootBestSolution(16));
    }

}
