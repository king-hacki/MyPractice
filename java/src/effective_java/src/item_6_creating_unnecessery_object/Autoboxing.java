package item_6_creating_unnecessery_object;

public class Autoboxing {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		WithAutoboxing.sum();
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("With autoboxing : " + duration);
		
		long start2 = System.currentTimeMillis();
		WithoutAutoboxing.sum();
		long end2 = System.currentTimeMillis();
		long duration2 = end2 - start2;
		System.out.println("Without autoboxing : " + duration2);
	}

}

class WithAutoboxing {
	
	static long sum () {
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) 
			sum += i; 
		return sum;
	}
	
}

class WithoutAutoboxing {
	
	static long sum () {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) 
			sum += i; 
		return sum;
	}
	
}