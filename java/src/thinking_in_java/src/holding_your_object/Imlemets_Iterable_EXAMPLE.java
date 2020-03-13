package holding_your_object;

import java.util.Iterator;

/*
 * Implementing Iterable allows an object to be the target of
 * the "for-each loop" statement.
 */

public class Imlemets_Iterable_EXAMPLE {

	public static void main(String [] args) {
		
		//	defauslt method
		for (String word : new ImplememtsIterable("some text to test in program".split(" ")))
			System.out.print(word + ", ");
		
		System.out.println();
		
		//	Java 8 method
		new ImplememtsIterable("some text to test in program".split(" "))
			.forEach((String word) -> 	System.out.print(word + ", "));
			
	}	
}

class ImplememtsIterable implements Iterable<String> {
	
	protected String [] text;

	public ImplememtsIterable(String[] text) {
		this.text = text;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < text.length ? true : false;
			}

			@Override
			public String next() {
				return text[index++];
			}
			
		};
	}
	
}
