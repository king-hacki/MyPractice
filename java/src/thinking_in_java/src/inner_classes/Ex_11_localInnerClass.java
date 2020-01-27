package inner_classes;

public class Ex_11_localInnerClass {

	public static void main(String[] args) {

		OuterRealize.method("realize interface in local inner class").doSome();
		
	}
}

interface DoSome {
	void doSome();
}

class OuterRealize {
	
	static DoSome method (String text) {
		class InnerRealize implements DoSome {	
			@Override
			public void doSome() {
				System.out.println(text);
			}			
			
		}
		return new InnerRealize();
	}
	
}