package inner_classes;

//TIJ4 Chapter Innerclasses, Exercise 7, page 354
/* Create a class with a private field and a private method. Create an
* inner class with a method that modifies the outer-class field and calls
* the outer class method. In a second outer-class method, create an object
* of the inner class and call its method, then show the effect on the
* outer-class object. 
*/

//TIJ4 Chapter Innerclasses, Exercise 8, page 354
/* Determine whether an outer class has access to the private elements of 
* its inner class. 
*/

public class Ex_7_8_privateOuterAccesFromInner {

	public static void main(String[] args) {

		OuterClass.Inner inner = new OuterClass().getInner();
		
		inner.setText("set private field whith current text");
		inner.pushOuterShowText();
		
		OuterClass.getPrivateInnerField();
	}

}


class OuterClass {
	
	private String text;

	private void showText() {
		System.out.println("private method in Outer.class");
	}
	
	Inner getInner () {
		return new Inner();
	}
	
	class Inner {
		
		private String innerPrivateText = "can access to private Inner field from Outer class"; 
		
		void setText(String t) {
			text = t;
			System.out.println(text);
		}
		
		void pushOuterShowText() {
			showText();
		}
	}
	
	
	static void getPrivateInnerField () {
		System.out.println(new OuterClass().new Inner().innerPrivateText);
	}
}

