package declaration_and_control;

abstract public strictfp class ClassDeclarationTests {}
strictfp final class A {}
abstract strictfp class B {
	abstract void method(); 
}
class D extends B {
	
//	B b = new B();	CE can't instantiate B
	B ba = new D();		//	OK
	
	@Override
	public final strictfp  void method() {}	//	OK	even this is override
}
//abstract final strictfp class C {}	CE can't be final and abstaract at one time
//static class C {}		CE	

abstract  class E {
	
	public abstract void methodA();
	protected abstract void methodB();
	protected abstract void methodC();
//	public abstract strictfp void methodC(); 	CE can't be strictfp
//	private abstract void methodC();			CE can't be private
	
}

abstract interface Test {}		//	OK can be abstract but it is redunant
interface VariablesTest {
	int a = 0;
}


interface StaticTest {
	
	static void method1() {
		
	}
	
	default void method2() {
		
	}
	
}


class FinalTest {
	final void testFinal() {
		
	}
}

class SonFinalTest extends FinalTest {
	
//	void testFinal() {}		CE testFinal is final
}











