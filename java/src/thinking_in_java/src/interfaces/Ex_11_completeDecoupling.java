package interfaces;

//TIJ4 Chapter Interfaces, Exercise 11, page 324
/* Create a class with a method that takes a String argument and produces a result
* that swaps each pair of characters in that argument. Adapt the class so that it
* works with interfaceprocessor.Apply.process().
*/

public class Ex_11_completeDecoupling {

	public static void main(String[] args) {
		
		Apply.process(new AdaptSwap(new Swap()), "Some text");
		
	}
}

interface Processor {
	String name();
	Object process(Object input);
}

class Apply {
	public static void process(Processor p, Object s) {
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
	}
}

class AdaptSwap implements Processor{

	Swap swap;
	AdaptSwap(Swap swap) {
		this.swap = swap;
	}
	
	@Override
	public String name() {
		return "Swap";
	}

	@Override
	public Object process(Object input) {
		return Swap.swap((String) input);
	}
	
}

class Swap {
	
	public static String swap (String text) {
		System.out.println("Do smth with text " + text);
		return text;
	}
	
}