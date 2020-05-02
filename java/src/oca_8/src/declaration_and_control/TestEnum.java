package declaration_and_control;

public class TestEnum {

	static Enum e;
	
	public static void main(String ...strings) {
		
//		Enum e = new Enum();	CE
		
//		System.out.println(Enum.valueOf("TEST"));
//		System.out.println(Enum.values());
		System.out.println(e.TEST.x);
		
		

		
		
		
		
	}
	
	static class Test {
		void p() {
			
		}
	}
	
}

enum Enum {
	TEST(1), TEST1(2);
	
	int x;
	
	Enum(int x) {
		this.x = x;
	}
}