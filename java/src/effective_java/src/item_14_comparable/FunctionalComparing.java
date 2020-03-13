package item_14_comparable;

import java.util.Comparator;
import static java.util.Comparator.comparingInt;

import java.util.Arrays;;

public class FunctionalComparing {

	public static void main(String[] args) {
		
		TestFunctioanlComparison t1 = new TestFunctioanlComparison(2, 1);
		TestFunctioanlComparison t2 = new TestFunctioanlComparison(3, 2);
		TestFunctioanlComparison t3 = new TestFunctioanlComparison(1, 4);
		TestFunctioanlComparison t4 = new TestFunctioanlComparison(2, 4);
		
		TestFunctioanlComparison [] array = {t1, t3, t2, t4};
		
		System.out.print("TestFunctioanlComparison Not sorted : ");
		for (TestFunctioanlComparison t : array)
			System.out.print(t + ", ");
		
		System.out.println();
		
		Arrays.sort(array);
		
		System.out.print("TestFunctioanlComparison Sorted : ");
		for (TestFunctioanlComparison t : array)
			System.out.print(t + ", ");
		

	}

}

class TestFunctioanlComparison implements Comparable<TestFunctioanlComparison> {

	int y;
	int x;
	
	public TestFunctioanlComparison (int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	private static final Comparator<TestFunctioanlComparison> first_X_Than_Y_Order = 
			comparingInt((TestFunctioanlComparison t) -> t.x)
				.thenComparingInt(t -> t.y);
	
	@Override
	public int compareTo(TestFunctioanlComparison o) {
		return first_X_Than_Y_Order.compare(this, o);
	}
	
	@Override
	public String toString() {
		return "" + y + " " + x;
	}
	
}
