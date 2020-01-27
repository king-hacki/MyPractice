package inner_classes;

//TIJ4 Chapter Innerclasses, Exercise 15, page361
/* Create a class with a non-default constructor and no default constructor.
* Create a second class that has a method that returns a reference to an
* object of the first class. Create the object that you return by making an
* anonymous inner class that inherits from the first class. 
*/


public class Ex_15_anonymous {

	public static void main(String[] args) {

		Number n =  NumberRelize.numberReturn();
		n.print();
		
	}

}


class Number {
	
	void print () {
		System.out.println("In number class");
	}
	
	Number (int number) {
		System.out.println(number);
	}
	
	Number () {
		
	}
	
}

class NumberRelize {
	
	static Number numberReturn () {
		return new Number(10) {
			
			public void print () {
				System.out.println("In anonymos class");
			}
			
		};
	}
	
}