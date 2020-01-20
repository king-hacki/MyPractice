package reusing_classes;

//TIJ4 Chapter Reusing, Exercise 18, page 265
/* Create a class with a static final field and a final field and demonstrate
* the difference between the two.
*/

public class Ex_18 {

	public static void main(String[] args) {
		
		Test t1 = new Test(10);
		Test t2 = new Test(20);
		
		System.out.println("final y in t1 : t1.y = " + t1.y);
		System.out.println("final y in t2 : t2.y = " + t2.y);
		
		System.out.println("static final x in Test class : Test.x = " + Test.x);
		
		//	t1.x = 5;		CE 
		//	t1.y1 = 5;		CE
		
		//  t1.o1 = new Test();		CE
		//	t1.o2 = new Test();		CE
	}

}

class Test {
	
	static final int x = 1;
	final static int xx = 1;	//	also right
	final int y1 = 5;
	final int y;	//	must be init in constructor
	
	static final Object o1 = new Object();
	final Object o2 = new Object();
	
	/*
	final int z;		CE		must init final  variable at the same time when create or
								in non-static block or method or in construtor
	z = 5;				cand do this			
	*/
	
	@SuppressWarnings("unused")
	void init_final() {
		final int z;
		z = 5;
		//	z = 6;		has already init
	}
	
	static void init_final_static () {
		//	static final int z;		can't do this static final must be init exactly
		//	z = 5;
	}
	@SuppressWarnings("unused")
	Test (int y) {
	//	static final int c1 = 6;	CE
		System.out.println(x);
		final int c = 6;	//	simple init
		this.y = y;		//	init final variable in construct
	}
}