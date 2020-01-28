package holding_your_object;

//TIJ4 Chapter Holding, Exercise 9, page 409
//Modify innerclasses/Sequence.java so that Sequence works with an Iterator
//instead of a Selector.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex_9_sequenceIterator {

	static List<Object> list = new ArrayList<>();
		
	private void add (Object o) {
		list.add(o);
	}
	
	
	
	public static void main(String[] args) {
		
		Ex_9_sequenceIterator sequence = new Ex_9_sequenceIterator();
		
		for (int i = 0; i < 10; i++) 
			sequence.add(Integer.toString(i));
		
		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

