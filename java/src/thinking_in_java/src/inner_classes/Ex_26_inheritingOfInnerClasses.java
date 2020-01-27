package inner_classes;

//TIJ4 Chapter Innerclasses, Exercise 26, page 383
/* Create a class with an inner class that has a non-default constructor
* (one that takes arguments). Create a second class with an inner
* class that inherits from the first inner class.
*/

public class Ex_26_inheritingOfInnerClasses {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		OuterInherit2.InnerInherit2 ii2 = new OuterInherit2().new InnerInherit2("Son");
		
	}

}


class OuterInherit1 {
	
	class InnerInherit1 {
		InnerInherit1(String name) {
			System.out.println("InnerInherit1.name = " + name);
		}
	}
}

class OuterInherit2 {
	
	class InnerInherit2 extends OuterInherit1.InnerInherit1 {
		
		InnerInherit2(String name) {
			new OuterInherit1().super(name);
			System.out.println("InnerInherit2.name = " + name);
		}
	}
}