package declaration_and_control;

public class VarArgsTest {

	public static void main(String[] args) {
		
		UsingVarArgs.reciveVarArgs();	//	OK
//		UsingVarArgs.reciveArray();			CE

		UsingVarArgs.reciveVarArgs("1", "2");	//	OK
//		UsingVarArgs.reciveArray("1", "2");			CE	
			
	}
}

class UsingVarArgs {
		

	final static void reciveArray(String [] strings) {
		System.out.println(strings.length);
	}
	
	final static void reciveVarArgs(String...strings) {
		System.out.println(strings.length);
	}
	
}

class TestConstructor {
	TestConstructor () {}
	void TestConstructor () {}
}