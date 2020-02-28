package item_13_clone;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//import java.lang.reflect.Field;

public class Reflection {

	public static void main(String[] args) throws Exception {
		
		Dad dad = new Dad();
		
		//	creating class object
		Class<?> c = dad.getClass();
		
		//	Get all only public methods 
//		Method[] methods = c.getDeclaredMethods();
		
//		for (Method method : methods) 
//            System.out.println(method.getName()); 
		
		Field privateField = c.getDeclaredField("i");
		privateField.setAccessible(true);
		System.out.println(privateField.get(dad));		//	can't do this
		
		Method privateMethod = c.getDeclaredMethod("getByReflection");
		privateMethod.setAccessible(true);
		privateMethod.invoke(dad);
	}

}

@SuppressWarnings("unused")
class Dad {
	
	private int i = 1;
	
	private void getByReflection () {
		System.out.println("Greeting, u get me :)");
	}
	
	void simple() {}
	
}
