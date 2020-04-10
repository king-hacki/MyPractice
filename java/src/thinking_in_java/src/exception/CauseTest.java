package exception;

public class CauseTest {

	
	static void a() {
		try {
			try {
				System.out.println("throw Exception");
				throw new CauseException("message CauseException");
			} catch (CauseException e) {
				e.printStackTrace(System.out);
				throw new Exception("message Exception", e);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void main(String[] args) {
		a();
	}
}

class CauseException extends Exception {
	CauseException (String message) {
		super(message);
	}
}
