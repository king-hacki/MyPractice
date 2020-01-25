package interfaces;

//TIJ4 Chapter Interfaces, Exercise 3, page 315
/* Create a base class with an abstract print() method that is overridden in a 
* derived class. The overridden version of the method prints the value of an int
* variable defined in the derived class. At the point of definition of this
* variable, give it a nonzero value. In the base-class constructor, call this
* method. In main(), create an object of the drived type, and then call its
* print() method. Explain the results.
*/ 

public class Ex_3_methodCallInConstAbstrClass {

	public static void main(String[] args) {
	
		/* Process of initialization:
		* 1. Storage for Derived derived allocated and initialized to binary zero
		* 2. Base() called
		* 3. Derived.print() called in Base() (derived.x = 0)
		* 4. Member initializers called in order (derived.x = 1)
		* 5. Body of Derived() called
		* 6. Derived.print() called (derived.x = 1)
		*/
		
		Derived derived = new Derived();	
		derived.print();	
		
		Base b = new Derived();
		derived.test();
//		b.test();
		b.print();

	}

}
abstract class Base {
	
	void test () { System.out.println("good test");}
	protected abstract void print ();
	Base() {
		print();
	}
}
class Derived extends Base{	
	private int x = 1;
	protected void print() {
		System.out.println("Derived.x = " + x);
	}
	void test () { System.out.println("bad test");}
}





