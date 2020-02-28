package item_12_toString;

public class SimpleTest {

	public static void main(String[] args) {

		TestFormatToString test1 = new TestFormatToString(1, 2);
		TestFormatToString test2 = new TestFormatToString(100, 200);
		
		System.out.println(test1);
		System.out.println();
		System.out.println(test2);
		
	}

}

class TestFormatToString {
	
	int x;
	int y;
	
	TestFormatToString(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//	Simple default toString() method
//	@Override
//	public String toString() {
//		return "x = " + x + "\ny = " + y;
//	}
	
	//	let's play with format
	
	//	oww. A thought it's something bigger, it's just simple format as in C
	//	but what else let's do it as example 
	@Override
	public String toString () {
		return String.format("%d, %d", x, y);
	}
	
}
