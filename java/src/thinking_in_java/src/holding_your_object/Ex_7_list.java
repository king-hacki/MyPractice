package holding_your_object;

import java.util.Arrays;
import java.util.List;

public class Ex_7_list {

	public static void main(String[] args) {
		
		List<ListTest> list = Arrays.asList(ListTest.arrayOfListTest);
		System.out.println(list);
		
		List<ListTest> sub = list.subList(5, 9);
		System.out.println(sub); 
		
		try {
			list.removeAll(list);		//		hahahaha well play unsuported))
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}

class ListTest {
	
	String name;
	
	static ListTest [] arrayOfListTest = {
			new ListTest("first"), 
			new ListTest("second"),
			new ListTest("third"),
			new ListTest("fourth"),
			new ListTest("fifth"),
			new ListTest("sixth"),
			new ListTest("seventh"),
			new ListTest("eighth"),
			new ListTest("nineth"),
			new ListTest("tenth")
			};
	
	ListTest(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
