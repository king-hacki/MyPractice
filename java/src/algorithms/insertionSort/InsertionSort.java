package src.algorithms.insertionSort;

import java.util.*;

class InsertionSort {
	public static ListNode insertionSortList(ListNode head) {
 
		if (head == null || head.next == null)
			return head;
 
		ListNode newHead = new ListNode(head.val);
		ListNode pointer = head.next;

		/////
		System.out.print("chain before while loop : ");
		printList(newHead);
		///// 

		// loop through each element in the list
		while (pointer != null) {
			// insert this element to the new list
 
			ListNode innerPointer = newHead;
			ListNode next = pointer.next;
 
			if (pointer.val <= newHead.val) {
				ListNode oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;

				/////
				System.out.print("chain before while loop : ");
				printList(newHead);
				/////

			} else {
				while (innerPointer.next != null) {
 
					if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
						ListNode oldNext = innerPointer.next;
						innerPointer.next = pointer;
						pointer.next = oldNext;
					}
 
					innerPointer = innerPointer.next;
				}	
 
				if (innerPointer.next == null && pointer.val > innerPointer.val) {
					innerPointer.next = pointer;
					pointer.next = null;
				}
			}
 
			// finally
			pointer = next;

			/////
			System.out.print("chain in the end of while loop : ");
			printList(newHead);
			/////
		}
 
		return newHead;
	}

	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}
