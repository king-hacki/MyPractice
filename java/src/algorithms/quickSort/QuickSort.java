package src.algorithms.quickSort;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort_right(int[] arr, int start, int end){
 
        int partition = partition(arr, start, end);
 
        if(partition - 1 > start) {
            quickSort_right(arr, start, partition - 1);
        }
        if(partition + 1 < end) {
            quickSort_right(arr, partition + 1, end);
        }
    }
 
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
 	
	System.out.println("start : " + start + " end : " + end);
	System.out.println("pivot : " + pivot);

        for(int i = start; i < end; i++){
            if(arr[i] < pivot){
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
	System.out.println("array in loop" + Arrays.toString(arr));
        }
 
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
	System.out.println("array before return" + Arrays.toString(arr));
        return start;
    }

	public static void quickSort_center(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		System.out.println("pivot : " + pivot);
		System.out.println("low : " + low + " high : " + high);
	
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		System.out.println("array in loop" + Arrays.toString(arr));
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort_center(arr, low, j);
 
		if (high > i)
			quickSort_center(arr, i, high);
	}
}
