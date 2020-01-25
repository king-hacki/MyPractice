package interfaces;

public class Ex_14_15_interfaceInheritance {

	public static void descriptionHuman (Humens h) {
		h.clever();
		h.technology();
	}
	
	
	public static void descriptionElfs (Elfs e) {
		e.agility();
		e.magic();
	}
	
	public static void descriptionOrcs (Orcs o) {
		o.number();
		o.power();
	}
	
	public static void descriptionSuperRace (SuperRace sr) {
		sr.undead();
	}
	
	public static void main(String[] args) {

		PaladinOfDead pod = new PaladinOfDead();
		descriptionHuman(pod);
		descriptionElfs(pod);
		descriptionOrcs(pod);
		descriptionSuperRace(pod);	
		
	}

}

interface Humens {
	void technology();
	void clever();
}

interface Elfs {
	void magic();
	void agility();
}

interface Orcs {
	void number();
	void power();
}

interface SuperRace extends Humens, Elfs, Orcs{
	void undead();
}

abstract class Paladin {
	
	void whoIs() {
		System.out.println("Paladin");
	}
	
}

class PaladinOfDead extends Paladin implements SuperRace {

	@Override
	public void technology() {
		System.out.println("Have technology");
	}

	@Override
	public void clever() {
		System.out.println("Have clever");
	}

	@Override
	public void magic() {
		System.out.println("Have magic");
	}

	@Override
	public void agility() {
		System.out.println("Have agility");
	}

	@Override
	public void number() {
		System.out.println("Have number");
	}

	@Override
	public void power() {
		System.out.println("Have power");
	}

	@Override
	public void undead() {
		System.out.println("Have unded");
	}

	@Override
	public void whoIs() {
		System.out.println("Undead Paladin");
	}
}



