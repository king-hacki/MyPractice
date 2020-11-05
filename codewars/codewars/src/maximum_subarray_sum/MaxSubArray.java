package maximum_subarray_sum;

public class MaxSubArray {
    public static int sequence(int[] arr) {

        if (arr.length != 0) {
            int m = arr[0];
            for (int i = 1, c = arr[0]; i < arr.length; i++) {
                c = Math.max(arr[i], arr[i] + c);
                m = Math.max(m, c);
            }
            return Math.max(m, 0);
        } else return 0;
    }

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

