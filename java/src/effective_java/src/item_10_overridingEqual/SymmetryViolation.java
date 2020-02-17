package item_10_overridingEqual;

public class SymmetryViolation {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
	SymmetryViolation.Test t = new SymmetryViolation().new Test("symmetry");
	String s = "symmetry";
	
	
	System.out.println("Test.equals(String) : " + t.equals(s));		//	true
	System.out.println("String.equals(Test) : " + s.equals(t));		//	false
		
	}
	
	class Test {
		
		String s;
		
		public Test (String s) {
			this.s = s;
		}
		
		
		//	in this equals broken violates symmetry | 
		@Override
		public boolean equals (Object o) {
			
			if (o instanceof Test) 
				return true;
			
			//	broken here because s.equals(this) will return false, 
			//	when this.equals(s) return true
			if (o instanceof String) 
				return true;
			
			return false;
			
		}

	}
}

