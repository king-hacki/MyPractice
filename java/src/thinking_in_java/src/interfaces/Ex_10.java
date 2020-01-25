package interfaces;

//TIJ4 Chapter Interfaces, Exercise 10, page 320
/* Modify Music5.java by adding a Playable interface. Move the play() declaration
* from Instrument to Playable. Add Playable to the derived classes by including
* it in the implements list. Change tune() so that it takes a Playable instead
* of and Instrument.
*/

public class Ex_10 {
	
	private static void allOrkestr (Instrument instrument) { System.out.println(instrument.what()); }
	private static void tune (Playable playable) { playable.play(Note.MIDDLE_C); }
	
	public static void main(String[] args) {
	
		Instrument [] instrArray = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Woodwind(),
				new Brass()
		};
		
		for (Instrument i : instrArray) 
			allOrkestr(i);	
		
		for (Instrument i : instrArray) 
			tune((Playable) i);	
		
	}

}

enum Note {
	MIDDLE_C;
}

interface Instrument {
	String what();
}

interface Playable {
	void play(Note n);
}

class Wind implements Instrument, Playable {

	@Override
	public void play(Note n) {
		System.out.println(this.what() + " play " + n);
	}

	@Override
	public String what() {
		return "Wind";
	}
}

class Percussion implements Instrument, Playable {

	@Override
	public void play(Note n) {
		System.out.println(this.what() + " play " + n);
	}

	@Override
	public String what() {
		return "Percussion";
	}
}

class Stringed implements Instrument, Playable {

	@Override
	public void play(Note n) {
		System.out.println(this.what() + " play " + n);
	}

	@Override
	public String what() {
		return "Stringed";
	}
}

class Woodwind implements Instrument, Playable {

	@Override
	public void play(Note n) {
		System.out.println(this.what() + " play " + n);
	}

	@Override
	public String what() {
		return "Woodwind";
	}
}

class Brass implements Instrument, Playable {

	@Override
	public void play(Note n) {
		System.out.println(this.what() + " play " + n);
	}

	@Override
	public String what() {
		return "Brass";
	}
}

