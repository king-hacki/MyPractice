package item_9_try_with_resources;

public class TestAutocloseable {

	public static void main(String[] args){

		try {
			try (Test test = new Test()) {
				Test.doSomething();
			}
		} catch (Exception e) {
			System.out.println("Can't close resource");
		}
	
	}

}

class Test implements AutoCloseable {
	
	public Test() {
		System.out.println("Construct");
	}
	
	public static void doSomething () {
		System.out.println("Do some stuff");
	}
	

	@Override
	public void close() throws Exception {
		System.out.println("Close");
	}
	
}



