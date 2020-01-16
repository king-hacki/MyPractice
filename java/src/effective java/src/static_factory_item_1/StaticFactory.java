/*
 * Static Factory method : 
 * 
 * 1) Static Factory method can return the instance of subclass of our class.
 * 2) Static Factory method can have better name then constructor which always have one name.
 * 3) Static Factory method can already created method.
 * 
 */


package static_factory_item_1;

public class StaticFactory {

	public static void main(String[] args) {
		
		Test test = new Test(1, 2);													// 		use simple constructor
		Test newInstance_test = Test.newInstance(4, 5);								// 		newIsntance return a new instance of the class
		Test getInstance_test = Test.getInstance();									//		always return already created instance 
		ExtendedTest getExtendedTest_test = Test.getExtendedTest(10, 15, 20);		//		I hope I made all right - factory return instance of subclass		
		
		System.out.println("[ + ] call add by instanse "
				+ "which create using constructor : " + test.add());
		
		System.out.println("[ + ] call add by instanse "
				+ "which create using newInstance : " + newInstance_test.add());
		
		System.out.println("[ + ] call add by instanse "
				+ "which create using getInstance : " + getInstance_test.add());
		
		System.out.println("[ + ] call add by instanse "
				+ "which create using getExtendedTest : " + getExtendedTest_test.add());
		
	}

}

class Test {
	
	int x;
	int y;
	
	// create t for getInstance  
	static Test t = new Test(5, 9); 
	
	int add () {
		return x + y;
	}
	// 	create constructor
	public Test (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	// create static factory newInstance
	static Test newInstance(int x, int y) {
		return new Test(x, y);
	}
	
	// create static factory getInstance
	static Test getInstance() {
		return t;
	}
	
	static ExtendedTest getExtendedTest (int x, int y, int z) {
		 return new ExtendedTest(x, y, z);
	}
	
	Test() {}
}

class ExtendedTest extends Test {

	int x;
	int y;
	int z;
	
	int add () {
		return x + y + z;
	}

	ExtendedTest (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}






