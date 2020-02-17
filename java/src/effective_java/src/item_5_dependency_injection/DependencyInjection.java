package item_5_dependency_injection;

public class DependencyInjection {

	public static void main(String[] args) {
		
		System.out.println(new TestInjection(new Injeciton(5)).i.x);
		
	}
}

class TestInjection {
	
	Injeciton i;
	
	TestInjection (Injeciton i) {
		System.out.println("Hello from TestInjection");
		this.i = i;
	}
	
}

class Injeciton {

	int x;
	
	public Injeciton (int x) {		
		System.out.println("Hello from Injection");
		this.x = x;
	}
}