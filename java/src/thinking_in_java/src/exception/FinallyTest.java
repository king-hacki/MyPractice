package exception;

public class FinallyTest {

	static void test() {
		try {
			try {
				throw new Exception();
			} finally {
				System.out.println("finally");
			}
		} catch (Exception e) {
			System.out.println("catch");
		} finally {
			System.out.println("second");
		}
	}
	
	static String testReturn () {
		try {
			return "returned";
		} finally {
			System.out.println("before method return");
		}
	}

	public static void main(String[] args) {
//		test();
		
		System.out.println(testReturn());

//		int i = 0;
//		try {
//			while (true) {
//				i++;
//				System.out.println(i);
//				if (i == 2)
//					break;
//			}
//		} finally {
//			System.out.println("test");
//		}
	}

}
