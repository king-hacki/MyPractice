package reusing_classes;

//TIJ4, Chapter Reusing, Exercise 1, page 241 
/* Create a simple class. Inside a second class, define a reference to an object of
* the first class. Use lazy initialization to instantiate this object.
*/

public class Ex_1 {
	
	public static void test (Ex_1 ex) {
		System.out.println(ex);
	}
	
	public String toString() {
		return "Hello!!!";
	}
	
	public static void main(String[] args) {
		
		new Simple().init();
		
	}

}

class Simple {
	
	Ex_1 ex;
	
	void init () {
		if (ex == null) {
			ex = new Ex_1();		//	lazy initialize
		}
		Ex_1.test(ex);
		// Ex_1.main(null);			just test calling main method; make circling
	}
	
}