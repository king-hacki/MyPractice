package reusing_classes;

public class Ex_21 {

	public static void main(String[] args) {
		Son s = new Son();
		s.print1();
		s.print2();
		// s.print3(); CE print3() is private
		
		Dad d = s;			//	upcast
		//	d.print1();		//	CE print1() is private
		d.print2();
	}

}

class Dad {
	
	final void print() {
		System.out.println("Dad print");
	}
		
	@SuppressWarnings("unused")
	private final void print1() {
		System.out.println("Dad print1");
	}
	
	void print2() {
		System.out.println("Dad print2");
	}
	
	@SuppressWarnings("unused")
	private void print3() {
		System.out.println("Dad print3");
	}
	
}

class Son extends Dad{
	
	/*						
	final void print() {					CE can't do this because of print() in Dad is final
		System.out.println("Son print");
	}
	*/
	//@Override	can write Override because print1() is not override it's just a new method
	public final void print1() {
		System.out.println("Son print1");
	}
	
	@Override
	void print2() {
		System.out.println("Son print2");
	}
	
	@SuppressWarnings("unused")
	private void print3() {
		System.out.println("Son print3");
	}
	
}