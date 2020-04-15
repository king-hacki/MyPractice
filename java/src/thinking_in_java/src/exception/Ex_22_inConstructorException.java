package exception;

public class Ex_22_inConstructorException {

	public static void main(String[] args) {

		try {
			FailingConstructor f = new FailingConstructor("first");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class FailingConstructor {

	String name;

	public FailingConstructor(String name) throws Exception {
		this.name = name;
		throw new Exception("exception in constructor FailingConstructor");
	}

}
