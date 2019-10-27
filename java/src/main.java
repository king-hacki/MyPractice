package src;

import java.util.Arrays;
import static src.algorithms.quickSort.QuickSort.*;

class Main {
	public static void main (String [] args) {

/*	insertion sort

		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);

		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		n1 = InsertionSort.insertionSortList(n1);
//*/

///*	quick sort

		int[] arr = {4, 5, 1, 2, 3, 3, 2, 4, 6, 2, 76};
       	 	quickSort_right(arr, 0, arr.length - 1);
       		System.out.println(Arrays.toString(arr));

//*/
	}
}

