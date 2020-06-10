package item_56_docs;

public class Test {
    public static void main(String[] args) {

    }

    /**
     *
     * @implSpec
     * This implementation return {@code x + y }
     *
     * This method complies with the {@index IEEE 754} standard.
     *
     * @param x
     * @param y
     * @param <T>
     * @throws Exception
     */
    <T> int add (int x, int y) throws Exception {
        return x + y;
    }

}
