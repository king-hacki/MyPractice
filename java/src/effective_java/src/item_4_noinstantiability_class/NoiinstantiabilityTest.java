package item_4_noinstantiability_class;

public class NoiinstantiabilityTest {

	public static void main(String[] args) {
		
		StaticTest.test();
		
	}

}


class StaticTest {
	
	static int x = 5;	
	static void test () {
		System.out.println("[ + ] in noiinstantiability class and x = " + x);
	}
	
	private StaticTest(){}		//	close our class
}

//	class TestInheritance extends StaticTest{}	//	can't do this because of constructor is private in parent