package polymorphism;

public class OverridenInnerClassesTest {
	



	public static void main(String[] args) {
	
		First f = new Second();
		((Second) f).third();
		
		Egg2 e2 = new BigEgg2();
		e2.g();
	
	}

}

class First {
	First () {
		System.out.println("first");
	}
}


class Second extends First {	
	void third() {
		System.out.println("third");
	}
	Second () {
		System.out.println("second");
	}
}

class Egg2 {
	protected class Yolk {
		
		public Yolk() { 
			System.out.println("Egg2.Yolk()"); 
		}	
		public void f() { 
			System.out.println("Egg2.Yolk.f()");
		} 
	}
	
	private Yolk y = new Yolk();
	
	public Egg2() { 
		System.out.println("New Egg2()"); 
	}
	
	public void insertYolk(Yolk yy) { 
		y = yy; 
	}
	
	public void g() { 
		y.f(); 
	}
	
}

	class BigEgg2 extends Egg2 { 	
		public class Yolk extends Egg2.Yolk {
			public Yolk() { 
				System.out.println("BigEgg2.Yolk()"); 
			}	
			public void f() { 
				System.out.println("BigEgg2.Yolk.f()"); 
			} 
		}
		
	  public BigEgg2() { 
		  insertYolk(new Yolk()); 
	  }
}