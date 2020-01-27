package inner_classes;

//TIJ4 Chapter Innerclasses, Exercise 23, page 371
/* Create an interface U with three methods. Create a class A with a method that
* produces a reference to a U by building an anonymous inner class. Create a second
* class B that contains an array of U. B should have one method that accepts and 
* stores a reference to U in the array, a second method that sets a reference in
* the array (specified by the method argument) to null, and a third method that
* moves through the array and calls the methods in U. In main, create a group of A 
* objects and a single B. Fill the B with U references produced by the A objects. 
* Use the B to call back into all the A objects. Remove some of the U references
* from the B.
*/


import java.util.ArrayList;

public class Ex_23_moreComplexNot {

	public static void main(String[] args) {
		
		B b = new B();
		
		for  (int i = 0; i < 10; i++) {
			b.add(new A().prodeceU());
		}
		
		b.setNull(2);
		b.setNull(6);
		
		b.call();
	}

}

interface U {
	void a();
	void b();
	void c();
}

class A {
	U prodeceU() {
		return new U() {

			@Override
			public void a() {
				System.out.println("Print a");
			}

			@Override
			public void b() {
				System.out.println("Print b");
			}

			@Override
			public void c() {
				System.out.println("Print c");
			}

		};
	}
}

class B {
	
	ArrayList<U> listU = new ArrayList<U>(); 
	
	void add(U u) {
		listU.add(u);
	}
	
	void setNull(int index) {
		listU.set(index, null);
	}
	
	void call() {
		for (U u : listU) {
			if (u != null) {
				u.a();
				u.b();
				u.c();
			} else System.out.println("u equal null");
		}
	}
}
