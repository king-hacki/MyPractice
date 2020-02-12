package holding_your_object;

import java.util.*;

//TIJ4 Chapter Holding, Exercise 18, page 422
/* Fill a HashMap with key-value pairs. Print the results to show ordering
* by hash code. Extract the pairs, sort by key, and place the result into a 
* LinkedHashMap. Show that the insertion order is maintained. 
*/

public class Ex_18_differentBetweenHashAndLinkedHashMaps {
	
	public static Map<Integer, String> createLinkedHasMap () {
		
		Map<Integer, String> map = new TreeMap<>();
		
		map.put(3, "three");
		map.put(4, "four");
		map.put(2, "two");
		map.put(6, "six");
		map.put(5, "fife");
		map.put(1, "one");
		
		System.out.println(map);
		
		return map;
		
	}

	public static void testDifference (Map<Integer, String> hashMap) {
		
		Set<Integer> set = new TreeSet<Integer>(hashMap.keySet());	
		Map<Integer, String> linkedMap = new LinkedHashMap<>();
		
		
		for (Integer i : set) 
			linkedMap.put(i, hashMap.get(i));
		
		System.out.println(linkedMap);
		
	}
	
	public static void  main(String [] arg) {
		testDifference(createLinkedHasMap());
	}
	
}
