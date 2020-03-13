package item_14_comparable;

import java.util.Arrays;

public class SimpleTest {

	public static void main(String[] args) {
		
		TestComparable t1 = new TestComparable(1);
		TestComparable t2 = new TestComparable(2);
		TestComparable t3 = new TestComparable(3);
		TestComparable t4 = new TestComparable(4);
		
		TestComparable [] array = {t4, t1, t3, t2};
		
		System.out.print("TestComparable Not sorted : ");
		for (TestComparable t : array)
			System.out.print(t.variable + " ");
		
		System.out.println();
		
		Arrays.sort(array);
		
		System.out.print("TestComparable Sorted : ");
		for (TestComparable t : array)
			System.out.print(t.variable + " ");
		

	}

}

class TestComparable implements Comparable<TestComparable> {

	int variable;
	
	public TestComparable (int variable) {
		this.variable = variable;
	}
	
	@Override
	public int compareTo(TestComparable o) {
	//	return variable - o.variable;		//	natural ordering
		return o.variable - variable;		//	reversed ordering
	}
	
}
