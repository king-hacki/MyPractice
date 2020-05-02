package strings;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class DifferentTest {

	public static void main(String[] args) {

//		TestLookingAt.testLookingAt();
//		TestSplit.testSplit();
//		TestBufReplacement.testReplacement();
		TestScanner.testScanner();
	}

}

//	compare find() and lookingAt()
class TestLookingAt {

	public static void testLookingAt() {

		String string = "some texst";
		Pattern pattern = Pattern.compile("s");
		Matcher matcher = pattern.matcher(string);

		System.out.println(matcher.lookingAt()); // just tell if pattern is in matcher text
		System.out.println(matcher.find()); // iterate through matcher text and find all

		// next circle iterate two times
		while (matcher.find())
			System.out.println(matcher.group());

		// next circle is circling
		while (matcher.lookingAt())
			System.out.println(matcher.group());

	}
}


//	test Pattern split
@SuppressWarnings("unused")
class TestSplit {

	public static void testSplit() {

		String string = "some texst";
		Pattern pattern = Pattern.compile(" ");

		Matcher matcher = pattern.matcher(string);

//		System.out.println(matcher.split());	CE Matcher doesn't has split() 
		System.out.println(Arrays.toString(pattern.split(string))); // wrap into Arrays.toString() because returned
																	// value is array

	}

}

//	test Matcher appendReplacement() and appendTail() 
class TestBufReplacement {

	public static void testReplacement() {

		String string = "some texst xxex";
		Pattern pattern = Pattern.compile("ewefwekfmwlkf");

		Matcher matcher = pattern.matcher(string);

		// using buffer to replace in
		StringBuilder builder = new StringBuilder();

		while (matcher.find()) {

			String find = matcher.group();
			
			//	sooo it is add to builder all what are before pattern. In documentation  non-terminal append-and-replace step.
			matcher.appendReplacement(builder, find);		
			System.out.println(builder.toString());
			

		}

		//	just return string
//		matcher.appendTail(builder);
//		System.out.println(builder.toString());

	}

}

//	test scanner
class TestScanner { 
	
	public static void testScanner() {
		
		Scanner scanner = new Scanner("1, 2, 3, 4.6, 5, 6");
		
		//	we can use regex delimiter which return Pattern object
		System.out.println(scanner.delimiter().toString());		//	show which delimiter now	
		
		scanner.useDelimiter(", ");	//	set delimiter ,
		while (scanner.hasNextInt() || scanner.hasNextDouble()) {  //	go through integer or double hasNext..() return boolean while next..() value
			System.out.println(scanner.hasNextInt());
			System.out.println( scanner.hasNextInt() ? scanner.nextInt() : scanner.nextDouble());	// can	ex InputMismatchException
		}
	}
	
}























