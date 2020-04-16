package strings;

public class Ex_7_regexStartCapitalEndPeriod {

	public static void main(String[] args) {
		
		String s = "Some data in period with 12.01.2020-12.05.2020";
		System.out.println(s.matches("[A-Z].+\\d{2}\\.\\d{2}\\.\\d{4}\\-\\d{2}\\.\\d{2}\\.\\d{4}"));	//	true
		
		
		
	}

}

