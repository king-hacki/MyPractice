package oca_8.declaration_and_control;

//	import java.*;	legacy but don't search anything in all java packages

//	import static java.lang.*;			CE
//	import static java.lang.Integer;	CE

import static java.lang.Integer.BYTES;
import static java.lang.System.*;



@SuppressWarnings("unused")
public class StaticImportTests {
	

	public  static void main(String[] args) {
//		out.println(MAX_VALUE);			CE : MAX_VALUE cause error because don't know from where get MAX_VALUE
		out.println(BYTES);				//	 But if if line 8 tell from whre BYTES everything OK
		
		
	}

}
