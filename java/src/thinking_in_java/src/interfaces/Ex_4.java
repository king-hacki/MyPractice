package interfaces;

//TIJ4 Chapter Interfaces, Exercise 4, page 315
/* Create an abstract class with no methods. Derive a class and add a method. 
* Create a static method that takes a reference to the base class, downcasts
* it to the derived class, and calls the method. In main(), demonstrate that it
* works. Now put the abstract declaration for the method in the base class, thus
* eliminating the need for the downcast.
*/ 

public class Ex_4 {

	public static void main(String[] args) {
		
		Son1 s = new Son1();
		Ex_4.method1(s);
		
		Son2 s2 = new Son2();
		Ex_4.method2(s2);

	}
	static void method1(Dad1 d) {
		((Son1) d).print();
	}
	
	static void method2(Dad2 d) {
		 d.print();
	}

}

abstract class Dad1 {}
class Son1 extends Dad1{
	void print () {
		System.out.println("Son1");
	}
}

abstract class Dad2 {
	abstract void print();
}
class Son2 extends Dad2 {
	void print() {
		System.out.println("Son2");
	}
}