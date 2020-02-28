package item_13_clone;

//import java.lang.reflect.Method;

public class SimpleRealization implements Cloneable {

	public static void main(String[] args) throws Exception {

		Experimental test1 = new Experimental(1, 2);
		System.out.println(test1);
		
//		SimpleRealization object = new SimpleRealization();
//		Class<?> c = object.getClass();
//		
//		Method methodClone = c.getSuperclass().getDeclaredMethod("clone");
//		methodClone.setAccessible(true);
//		Experimental cloneTest = (Experimental) methodClone.invoke(object);
//		
//		System.out.println(cloneTest);		//	runtime error cant cast		 :(
		
		
	}
	
}


// Simple immutable 
class Experimental {
	
	int x;
	int y;
	
	public Experimental (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString () {
		return "x = " + x + "\ny = " + y;
	}
}