package polymorphism;

//TIJ4 Chapter Polymorphism, Exercise 10, page 290
/* Create a base class with two methods. In the first method, call the second
* method. Inherit a class and override the second method. Create an object of
* the derived class, upcast it to the base type, and call the first method. 
* Explain what happens.
*/

public class Ex_10_goodShowOfPolimorphism {

	public static void main(String[] args) {

//		Base p = new Derived();
//		
//		// automatic upgrade to base-class to call base-class method Base.one()
//		// which,by polymorphism, will call the derived-class method Derived.second():
//		
//		p.one();
//		
//		Derived d = new Derived();
//		d.one();
//		
		
		//	My test not for exercion check defferent between Dad d = new Son() and Son s = new Son()
		
		Test t = new Test();
		System.out.println("----------------");
		System.out.println(t.x);
		System.out.println(t.getX());
		System.out.println("----------------");
		
		SuperTest st = new SuperTest();
		System.out.println("----------------");
		System.out.println(st.x);
		System.out.println(st.getX());
		System.out.println("----------------");
		
		SuperTest stt = new Test();
		System.out.println("----------------");
		System.out.println(stt.x);
		System.out.println(stt.getX());
		System.out.println("----------------");
	}

}

class Base {	
	void one() {
		System.out.println("Base method one has called");
		this.second();
	}
	void second() {
		System.out.println("Base method second has called");
	}
	
}
class Derived extends Base {	
	void second() {
		System.out.println("Derived method second has called");
	}
}


class SuperTest {
	int x = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
}

class Test extends SuperTest{
	int x = 1;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}









