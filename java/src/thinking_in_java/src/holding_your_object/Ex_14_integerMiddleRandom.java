package holding_your_object;

//TIJ4 Chapter Holding, Exercise 14, page 412
/* Create an empty LlinkedList<Integer>. Using a ListIterator, add Integers
* to the list by always inserting them in the middle of the list.
*/

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Ex_14_integerMiddleRandom {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		ListIterator<Integer> listIterator = list.listIterator(list.size() / 2); 
		
		for (int i = 0; i < 20; i++) 
			listIterator.add(i);
		
		for (Integer l : list) 
			System.out.println(l);
		
	}

}

