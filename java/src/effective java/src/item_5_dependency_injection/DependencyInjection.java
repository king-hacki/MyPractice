package item_5_dependency_injection;

import java.util.Objects;

public class DependencyInjection {

	public static void main(String[] args) {
		
		TestInjection test = new TestInjection(5, "Chikens");
		System.out.println(test);
	}

}

class TestInjection {
	
	int x;
	String text;
	
	TestInjection(int x, String text) {
		this.text = Objects.requireNonNull(text);
		this.x = x;
	}
	
	public String toString() {
		return "[ + ] " + text + " is " + x;
	}
}