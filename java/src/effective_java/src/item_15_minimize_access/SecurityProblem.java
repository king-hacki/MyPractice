package item_15_minimize_access;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


/*
 * 	Instance fields of public classes should rarely be public
 * 	If an instance field is nonfinal or is a reference to a mutable object, 
 * 	then by making it public, you give up the ability to limit the values that can be stored in the field. 
 * 	This means you give up the ability to enforce invariants involving the field
 * 
 * 	Also, you give up the ability to take any action when the field is modified, 
 * 	so classes with public mutable fields are not generally thread-safe
 * 
 * 	Note that a nonzero-length array is always mutable, 
 * 	so it is wrong for a class to have a public static final array field, 
 * 	or an accessor that returns such a field. If a class has such a field or accessor, 
 * 	clients will be able to modify the con- tents of the array.
 *  
 * 	This is a frequent source of security holes:
 */

public class SecurityProblem {


	// Potential security hole!
	public static final Robot [] BAD_ROBOTS = {};
	
	private static final Robot[] GOOD_ROBOTS = {};
	public static final Collection<Robot> LIST_OF_GOOD_ROBOTS = 
			Collections.unmodifiableCollection(Arrays.asList(GOOD_ROBOTS));
	
	public static final Robot[] robots () {
		return GOOD_ROBOTS.clone();
	}
	
	public static void main(String[] args) {
		

		TestSecurity.test();
		
	}

}

class Robot {
	
	String name;
	
	public Robot(String name) {
		this.name = name;
	}
	
}


class TestSecurity {

	public static void test () {
		
		//	Oooups new Robot() added in 
		SecurityProblem.BAD_ROBOTS[0] = new Robot("Lee");		//	calls runtime error
		
		//	good 
		SecurityProblem.LIST_OF_GOOD_ROBOTS.add(new Robot("Mark"));
		
		//	or this variant
		SecurityProblem.robots()[0] = new Robot("Mark");		//	kind strange
		
	}
	
}




