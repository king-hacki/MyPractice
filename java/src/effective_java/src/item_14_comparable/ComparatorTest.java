package item_14_comparable;

import java.util.Arrays;

public class ComparatorTest {

	public static void main(String[] args) {
		
		TestByComparators t1 = new TestByComparators(new TempAA(1), new TempB("Test1"));
		TestByComparators t2 = new TestByComparators(new TempAA(1), new TempB("Test2"));
		TestByComparators t3 = new TestByComparators(new TempAA(1), new TempB("Test3"));
		TestByComparators t4 = new TestByComparators(new TempAA(2), new TempB("Test4"));
		
		
		TestByComparators [] array = {t2, t4, t3, t1};
		
		System.out.print("TestByComparators Not sorted : ");
		for (TestByComparators t : array)
			System.out.print(t + ", ");
		
		System.out.println();
		
		Arrays.sort(array);
		
		System.out.print("TestByComparators Sorted : ");
		for (TestByComparators t : array)
			System.out.print(t + ", ");
		


	}

}

class TestByComparators implements Comparable<TestByComparators> {

	TempAA a;
	TempB b;
	
	public TestByComparators (TempAA a, TempB b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(TestByComparators o) {
		int result = Integer.compare(this.a.test, o.a.test);
		if (result == 0) {
			result = String.CASE_INSENSITIVE_ORDER.compare(this.b.test, o.b.test);
		}
		return result;
	}
	
	public String toString() {
		return "" + a + b;
	}
	
}

class TempAA {
	
	int test;
	
	public TempAA(int test) {
		this.test = test;
	}
	
	public String toString() {
		return Integer.toString(test);
	}

}

class TempB {
	
	String test;
	
	public TempB(String test) {
		this.test = test;
	}
	
	public String toString() {
		return test;
	}
	
}