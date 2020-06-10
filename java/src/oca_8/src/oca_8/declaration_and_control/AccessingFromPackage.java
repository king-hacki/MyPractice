package oca_8.declaration_and_control;

import static java.lang.System.out;
import oca_8.for_test_import_purpose.Public;
import oca_8.for_test_import_purpose.SecondPublic;	//	can import two public class
//import chapter_1.for_test_import_purpose.Default;		CE because Default is not-public

public class AccessingFromPackage {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Public p = new Public();
		SecondPublic sp = new SecondPublic();
//		Default d = new Default();		CE can't get access because Default is not-public
//		out.println(p.string);			CE can't access to string because it's default access
		out.println(sp.string);			//	OK
		

	}

}
