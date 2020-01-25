package interfaces;

//interfaces/DiamondInheritance13.java
//TIJ4 Chapter Interfaces, Exercise 13, page 328
/* Create an interface, and inherit two new interfaces from that
* interface. Multiply inherit a third interface from the second
* two. 
*/

public class Ex_13_diamondProblemInJava {

	public static void main(String[] args) {
		
		ABC ref = new ABC(); 
		
		ref.printA();
		ref.printB();
		ref.printC();
		ref.printD();
	}
}

interface A {
	void printA();
}

interface B extends A {
	void printB();
}

interface C extends A{
	void printC();
}

interface D extends C, B {
	void printD();
}

class ABC implements D {

	@Override
	public void printA() {
		System.out.println("print A");
	}
	@Override
	public void printB() {
		System.out.println("print B");
	}
	@Override
	public void printC() {
		System.out.println("print C");
	}
	@Override
	public void printD() {
		System.out.println("print D");
	}
	
}