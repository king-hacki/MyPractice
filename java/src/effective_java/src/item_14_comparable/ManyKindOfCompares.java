package item_14_comparable;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class ManyKindOfCompares {

	public static void main(String[] args) {

		ManyKinds t1 = new ManyKinds(1, 6L, new TempA(1, "Test1"));
		ManyKinds t2 = new ManyKinds(2, 3L, new TempA(2, "Test1"));
		ManyKinds t3 = new ManyKinds(3, 5L, new TempA(4, "Test2"));
		ManyKinds t4 = new ManyKinds(4, 2L, new TempA(4, "Test1"));
		
		ManyKinds [] array = {t1, t4, t3, t2}; 
		
		System.out.print("ManyKinds Not sorted : ");
		for (ManyKinds t : array)
			System.out.print(t + ", ");
		
		System.out.println();
		
		Arrays.sort(array);
		
		System.out.print("ManyKinds Sorted : ");
		for (ManyKinds t : array)
			System.out.print(t + ", ");
		


	}

}

@SuppressWarnings("unused")
class ManyKinds implements Comparable<ManyKinds> {

	int intValue;
	long longValue;
	
	TempA a;
	
	public ManyKinds(int intValue, long longValue, TempA a) {
		this.intValue = intValue;
		this.longValue = longValue;
		this.a = a;
	}

	
	private static final Comparator<ManyKinds> COMPARING_BY_INT = comparingInt((ManyKinds c) -> c.intValue)
			.thenComparingLong(c -> c.longValue)
			.thenComparing(c -> c.a);
	
	private static final Comparator<ManyKinds> COMPARING_BY_LONG = comparingLong((ManyKinds c) -> c.longValue)
			.thenComparingInt(c -> c.intValue)
			.thenComparing(c -> c.a);
	
	private static final Comparator<ManyKinds> COMPARING_BY_A_OBJECT = comparing((ManyKinds c) -> c.a)
			.thenComparingLong(c -> c.longValue)
			.thenComparingInt(c -> c.intValue);
			
	
	@Override
	public int compareTo(ManyKinds o) {		
	//	return COMPARING_BY_INT.compare(this, o);	//	sort object where first is int value
	//	return COMPARING_BY_INT.compare(this, o);	//	sort object where first is int long
		return COMPARING_BY_A_OBJECT.compare(this, o);	//	sort object where first is int a object
	}
	
	@Override
	public String toString() {
		return intValue + "_" + longValue + "_" + a;
	}
}

class TempA implements Comparable<TempA>{
	
	int test;
	String s;
	
	public TempA(int test, String s) {
		this.test = test;
		this.s = s;
	}
	
	@Override
	public int compareTo(TempA o) {
		return comparingInt((TempA c) -> c.test)
					.thenComparing(c -> c.s)
					.compare(this, o);
	}
	
	@Override
	public String toString() {
		return test + "_" + s;
	}

}