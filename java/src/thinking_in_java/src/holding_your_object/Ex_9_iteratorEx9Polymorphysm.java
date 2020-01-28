package holding_your_object;

//TIJ4 Chapter Holding, Exercise 10, page 409
/* Change Exercise 9 in the Polymorphism chapter to use an ArrayList to
* hold the Rodents and an Iterator to move through the sequence of 
* Rodents.
*/

import static polymorphism.Ex_9_12_orderOfInitializeConstructors.animals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex_9_iteratorEx9Polymorphysm {

	static private List<Object> listAnimal = Arrays.asList((Object)animals);
	static private Iterator<Object> iterator = listAnimal.iterator();   
	
	public static void main(String [] args) {
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
