import java.util.Arrays;

class Main {
	public static void main (String [] args) {
		
		int[] arr = {3, 4, 1, 8, 0, 2, 9, 7, 6, 3, 4, 5};

        	QuickSort.quickSort(arr, 0, arr.length - 1);
        	System.out.println(Arrays.toString(arr));
	}
}

