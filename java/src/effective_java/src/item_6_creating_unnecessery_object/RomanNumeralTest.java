
package item_6_creating_unnecessery_object;

import java.util.regex.Pattern;

/**
 * @author kinghacki
 *
 */
public class RomanNumeralTest {

	
	public static void main(String[] args) {
		
		System.out.println(BadRomanNumerals.isRomanNumeral("XXX"));
		System.out.println(GoodRomanNumerals.isRomanNumeral("XXX"));
		
	}

}


class BadRomanNumerals {
	
	static boolean isRomanNumeral (String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}
	
}


class GoodRomanNumerals {
	
	private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	
	static boolean isRomanNumeral (String s) {
		 return ROMAN.matcher(s).matches();
	}
	
}
