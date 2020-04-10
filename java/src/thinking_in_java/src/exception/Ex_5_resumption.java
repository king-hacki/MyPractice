package exception;

//exceptions/Ex5.java
//TIJ4 Chapter Exceptions, Exercise 5, page 452
/* Create you own resumption-like behavior using a while loop that repeats
* until an exception is no longer thrown.
*/

public class Ex_5_resumption {
	
	private static int[] array = new int[2];
	
	static int x = 5;
	
	public static void main(String[] args) {
		
		while(true) {
			try {
				
				array[x] = 1;
				System.out.println(array[x]);
				break;
				
			} catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println("Caught ArrayIndexOutOfBoundsException");
				e.printStackTrace(System.out);
				x--;
				
			}
		}
		
		System.out.println("Now, we're done.");
	}
}
