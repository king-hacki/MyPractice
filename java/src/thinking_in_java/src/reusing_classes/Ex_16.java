package reusing_classes;
//TIJ4, Chapter Reusing, Exercise 16, page 262
/* Create a class called Amphibian. From this, inherit a class called Frog. 
* Put appropriate methods in the base class. In main(), create a Frog and upcast
* it to Amphibian, and demonstrate that all the methods still work.
*/
//TIJ4, Chapter Reusing, Exercise 17, page 262
/* Modify Exercise 16 so that Frog overrides the method definitions from 
* the base class (provides new definitions using the same method 
* signatures). Note what happesn in main(). 
* ( Exersice 16:Create a class called Amphibian. From this, inherit a class
* called Frog. Put appropriate methods in the base class. In main(), create a
* Frog and upcast it to Amphibian, and demonstrate that all the methods still 
* work.)
*/
public class Ex_16 {

	public static void main(String[] args) {
		
		Frog frog = new Frog();
		Amphibian.print(frog);
	}

}

class Amphibian {
	
	static void print (Amphibian a) {
		System.out.println("Amphibian");
	}
	
}

class Frog extends Amphibian {
	static void print (Amphibian a) {
		System.out.println("Frog");
	}
}