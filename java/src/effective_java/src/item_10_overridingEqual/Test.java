package item_10_overridingEqual;

import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
				
		UsingByTest ubt1 = new UsingByTest(1, 2);
		UsingByTest ubt2 = new UsingByTest(2, 1);
		
		System.out.println(ubt1 == ubt2);			//	false
		System.out.println(ubt1.equals(ubt2));		//	false		
		
		String s1 = "test";
		String s2 = "test2";
		
		System.out.println(s1 == s2);			//	false
		System.out.println(s1.equals(s2));		//	false
		
		System.out.println(ubt1.getClass());	//	class item_10_overridingEqual.UsingByTest
		System.out.println(ubt2.getClass());	//	class item_10_overridingEqual.UsingByTest
		
		List<String> list1 = new LinkedList<String>(); 
		List<String> list2 = new LinkedList<String>();
		
		System.out.println(list1 == list2);				//	false
		System.out.println(list1.equals(list2));		//	true, because override in AbstractList
		
		list1.add("test1");
		list1.add("test2");
		
		System.out.println(list1 == list2);				//	false
		System.out.println(list1.equals(list2));		//	here is false, because overr. equals method goes also be elements
		
		SonTest st1 = new SonTest(1, 2);
		SonTest st2 = new SonTest(1, 2);
		
		SonTest st3 = new SonTest(1);
		SonTest st4 = new SonTest(2);
		
		System.out.println(st1 == st2);					//	false
		System.out.println(st1.equals(st2));			//	true , using dad's equals()
		System.out.println(st3 == st4);					//	false
		System.out.println(st3.equals(st4));			//	true , using dad's equals()
		
		Integer x1 = 6;
		Integer x2 = 7;
		System.out.println(x1 == x2);					//	false
		System.out.println(x1.equals(x2));				//	false
		
		
	}	
}

class UsingByTest {
	
	int x;
	int y;
	
	public UsingByTest(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}

class DadTest {
	
	int x;
	
	public DadTest (int x) {
		this.x = x;
	}
	
	public DadTest () {}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		
		if (this.x == ((DadTest) o).x)
			return true;
		
		return false;
	}
	
}

class SonTest extends DadTest {

	int y;
	
	SonTest (int y, int x) {
		super (x);
		this.y = y;
	}
	
	SonTest(int y) {
		this.y = y;
	}
	
	
}