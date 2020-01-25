package polymorphism;

//TIJ4 Chapter Polymorphism, Exercise 15, page 303
//Add a RectangularGlyph to PolyConstructors.java and demonstrate the problem
//described in this section.

public class Ex_15_methodCallInConstructor {

	public static void main(String[] args) {
		
		//	showing problem with overridden method-calls in base-constructor
		new RoundGlyph(5);
		new RectangularGlyph(3, 6);

	}

}
class Glyph {
	void draw() { System.out.println("Glyph.draw()"); }
	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()"); 
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
}

class RectangularGlyph extends Glyph {
	private int length = 2;
	private int width = 4;
	RectangularGlyph(int l, int w) {
		length = l;
		width = w;
		System.out.println("RectangularGlyph.RectangularGlyph(), length = " 
			+ length + ", width = " + width);
	}
	void draw() {
		System.out.println("RectangularGlyph.draw(), length = " + length 
			+ ", width = " + width);
	}
}