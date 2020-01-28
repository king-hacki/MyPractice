package holding_your_object;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Ex_12_llistIterator {
	
	static private Random random = new Random();
	static private List<Integer> list = new ArrayList<>();  
	static private List<Integer> reverseList = new ArrayList<>(); 
	
	static void randomFill () {
		list.add(random.nextInt(20));
	}
	
	static int getSize(List<Integer> l) {
		return l.size();
	}
	
	static void display(List<Integer> l) {
		System.out.println(l);
	}
	
	public static void main (String [] args) {
		
		int i = 0;
		while (i++ < 20)
			randomFill();
		
		ListIterator<Integer> listIterator = list.listIterator(getSize(list));
		
		while (listIterator.hasPrevious()) 
			reverseList.add(listIterator.previous());
		
		display(list);
		display(reverseList);
	}

}
