package holding_your_object;

import java.util.*;

public class Ex_25_26_workWithTextUsingMap {

	public static int count = 0;
	
	public static ArrayList<Integer> containe (String word) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < word.length(); i++ ) 
			list.add(count++);
			
		return list;
	}
	
	public static Map <String, ArrayList<Integer>> work (String text) {
		
		Map <String, ArrayList<Integer>> map = new LinkedHashMap<>();
		
		
		for (String word : text.split("\\W"))
			map.put(word, containe(word));
		
		return map;
		
	}
	
	
	public static void main(String[] args) {

		System.out.println("Map : " + work("text to test"));
		
		
	}

}
