package inner_classes;

//TIJ4 Chapter Innerclasses, Exercise 1, page 347
/* Write a class named Outer that contains an inner class named Innet. 
* Add a method to Outer that returns an object of type Inner. In main(),
* create and initialize a reference to an Inner.
*/



public class Ex_1_2_simpleExample {

	public static void main(String[] args) {
		
		Outer.Inner inner1 = new Outer().new Inner(); 
		Outer.Inner inner2 = new Outer().getInner();
		
		System.out.println(inner1);
		System.out.println(inner2);
		
	}
}

class Outer {	
	
	private String text = "show me";
	
	Inner getInner() {
		return new Outer.Inner();
	}
	
	class Inner {
	
		public String toString() {
			return text;
		}
		
		Inner () {
			System.out.println("I was created");
		}
	}
}
