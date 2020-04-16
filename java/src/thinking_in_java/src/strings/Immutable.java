package strings;

public class Immutable {

	public static String upper(String a) {
		return a.toUpperCase();
	}
	
	public static void main(String[] args) {
	
		String test = "ttt";
		String testUp = upper(test);
		
		System.out.println(test);
		System.out.println(testUp);
	}

}
