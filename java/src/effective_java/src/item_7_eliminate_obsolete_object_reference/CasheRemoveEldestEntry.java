package item_7_eliminate_obsolete_object_reference;

import java.util.LinkedHashMap;
import java.util.Map;

public class CasheRemoveEldestEntry {

	// Refers to the max size of the map following which 
    // the removal takes place of the eldest entry 
	private static final int MAX = 6;

	@SuppressWarnings("serial")
	public static void main(String[] args) {

		// Creating the linked hashmap and implementing 
        // removeEldestEntry() to MAX size 
		
		LinkedHashMap<Integer, String> lhm = new  LinkedHashMap<Integer, String>() {
			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
				return size() > MAX;
			}
		};
	
		// Adding elements using put() 
		lhm.put(0, "Welcome"); 
		lhm.put(1, "To"); 
		lhm.put(2, "The"); 
		lhm.put(3, "World"); 
		lhm.put(4, "Of"); 
		lhm.put(5, "geeks"); 
		
		System.out.println("" + lhm); 
		
		// Adding more elements 
		lhm.put(6, "GeeksforGeeks"); 
		
        // Displying the map after adding one more element 
        System.out.println("" + lhm); 
  
        // Adding more elements 
        lhm.put(7, "Hello"); 
  
        // Displying the map after adding one more element 
        System.out.println("" + lhm); 
	}

}


