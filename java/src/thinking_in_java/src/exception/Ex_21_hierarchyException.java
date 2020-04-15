package exception;

//exceptions/Ex21.java
//TIJ4 Chapter Exceptions, Exercise 21, page 488
//Demonstrate that a derived-class constructor cannot catch exceptions thrown
//by its base-class constructor.

public class Ex_21_hierarchyException {

	public static void main(String[] args) {

		try {
//			Ex_21_hierarchyException.Base b =  new Ex_21_hierarchyException().new Base("message");
			Ex_21_hierarchyException.Derived b = new Ex_21_hierarchyException().new Derived("message");
		} catch (TestException e) {
			e.printStackTrace();
		}
	}

	class Base {
		public Base(String message) throws TestException {
			System.out.println("Base " + message);
			throw new TestException();
		}
	}

	class Derived extends Base {
		public Derived(String message) throws TestException {
			super(message);
			
			// not this way, 'catch' without 'try' not allowed:
			// catch(BaseException e) {}
			// not this way either, because call to super
			// must be first statement in constructor:		
			// try {
			//	super(message);
			// } catch(TestException e) {}
			
			System.out.println("Derived " + message);

		}
	}

	class TestException extends Exception {
	}
}
