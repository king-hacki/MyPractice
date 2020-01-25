package polymorphism;

//TIJ4 Chapter Polymorphism, Exercise 1, page 281
/* Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. 
* Demonstrate that an instance of each type can be upcast to Cycle via a ride()
* method.
*/

//TIJ4 Chapter Polymorphism, Exercise 5, page 286
/* Starting from Exercise 1, add a wheels() method in Cycle, which returns the
* number of wheels. MOdify ride() to call wheels() and verify that polymorphism
* works.
*/

public class Ex_1_5_cycle {

	public static int ride (Cycle c) {
		return c.wheels();
	}
	
	public static void main(String[] args) {
		
/* Ex 1 tests		
		Cycle c = new Cycle();
		
		c.ride(c);
		c.ride(new Unicycle());
		c.ride(new Bicycle());
		c.ride(new Tricycle());
		
		Tricycle tric  = new Tricycle();
		tric.ride(c);
*/	
		
		Cycle c = new Cycle();
		
		
		Cycle bc = new Bicycle();
		Cycle uc = new Unicycle();
		Cycle tc = new Tricycle();
		
		System.out.println(ride(c));
		System.out.println(ride(bc));
		System.out.println(ride(uc));
		System.out.println(ride(tc));
		
		Bicycle bc2 = new Bicycle();
		System.out.println(ride(bc2));
	}

}


class Cycle { 
	
	protected int wheels;
	
	void ride (Cycle cycle) {
		System.out.println("[ + ] ride " + cycle);
	}
	
	public String toString () {
		return "Cycle";
	}
	
	int wheels () {		
		return wheels;
	}
	
}

class Unicycle extends Cycle {
	
	int wheels = 1;
	
	public String toString () {
		return "Unicycle";
	}

	public int wheels () {
		return wheels;
	}
}

class Bicycle extends Cycle {
	
	int wheels = 2;
	
	public String toString () {
		return "Bicycle";
	}

	
	public int wheels () { 
		return wheels; 
	}
	 
}


class Tricycle extends Cycle {
	
	int wheels = 3;
	
	public String toString () {
		return "Tricycle";
	}
	

	public int wheels () {
		return wheels;
	}
}