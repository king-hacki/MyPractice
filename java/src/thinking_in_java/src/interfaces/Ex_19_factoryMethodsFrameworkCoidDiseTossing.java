package interfaces;

//TIJ4 Chapter Interfaces, Exercise 19, page 342
/* Create a framework using Factory Methods that performs both coin
* tossing and dice tossing.
*/

import java.util.Random;

public class Ex_19_factoryMethodsFrameworkCoidDiseTossing {

	private static void fabricaMethod (TossFabrica fabrica) {
		Toss toss = fabrica.getToss();
		toss.toss();
	}
	
	public static void main(String[] args) {

		
		//	can do this in random array
		fabricaMethod(new CoinFabrica());
		fabricaMethod(new CoinFabrica());
		fabricaMethod(new CoinFabrica());
		fabricaMethod(new CoinFabrica());
		fabricaMethod(new CoinFabrica());
		
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		fabricaMethod(new DiceFabrica());
		
	}

}

interface Toss {
	void toss();
}

interface TossFabrica {
	Toss getToss();
}

class Coin implements Toss {
	
	public static final int varients = 2;

	@Override
	public void toss() {
		Random random = new Random();
		switch (random.nextInt(varients)) {
			case 0 : System.out.println("Emblem");
			case 1 : System.out.println("Number");
		}
	}
}

class Dice implements Toss {
	
	public static final int varients = 6;

	@Override
	public void toss() {
		Random random = new Random();
		switch (random.nextInt(varients)) {
			case 0 : System.out.println("1");
			case 1 : System.out.println("2");
			case 2 : System.out.println("3");
			case 3 : System.out.println("4");
			case 4 : System.out.println("5");
			case 5 : System.out.println("6");
		}
	}
}

class CoinFabrica implements TossFabrica {

	@Override
	public Toss getToss() {
		return new Coin();
	}
	
}

class DiceFabrica implements TossFabrica {

	@Override
	public Toss getToss() {
		return new Dice();
	}
	
}









