package inner_classes;

//TIJ4 Chapter Innerclasses, Exercise 21, page 367
/* Create an interface that contains a nested class that has a static method that
* calls the methods of your interface and displays the results. Implement your
* interface and pass an instance of your implementation to the method. 
*/


public class Ex_21_nestedClassInInterface {

	public static void main(String[] args) {

		Realizer r = new Realizer();
		Realizable.Realize.method(r);
		
	}

}


interface Realizable {
	String realize();
	static class Realize {

		public static void method(Realizable r) {
			System.out.println(r.realize());
		}
	}
}

class Realizer implements Realizable {

	@Override
	public String realize() {
		return "I was realized";
	}
	
}