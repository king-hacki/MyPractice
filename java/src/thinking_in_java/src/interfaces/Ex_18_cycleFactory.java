package interfaces;

//TIJ4 Chapter Interfaces, Exercise 18, page 342
/* Create a Cycle interface, with implementations Unicycle, Bicycle and 
* Tricycle. Create factories for each type of Cycle, and code that uses
* these factories.
*/

public class Ex_18_cycleFactory {
	
	private static void cycleFactory (CycleFactory factory) {
		Cycle cycle = factory.getCycle();
		cycle.move();
		System.out.println("Theare are " + cycle.getWheels() + " wheels");
	}

	public static void main(String[] args) {
		cycleFactory(new FactoryClassBicycle());
		cycleFactory(new FactoryClassUnicycle());
		cycleFactory(new FactoryClassTricycle());
	}

}

interface Cycle {
	void move();
	int getWheels();
}

interface CycleFactory {
	Cycle getCycle();
}

class Bicycle implements Cycle {
	final int wheels = 2;
	@Override
	public void move() {
		System.out.println("Bicycle move");
	}
	@Override
	public int getWheels() {
		return wheels;
	}	
}

class Unicycle implements Cycle {
	final int wheels = 1;
	@Override
	public void move() {
		System.out.println("Unicycle move");
	}
	@Override
	public int getWheels() {
		return wheels;
	}	
}

class Tricycle implements Cycle {
	final int wheels = 3;
	@Override
	public void move() {
		System.out.println("Tricycle move");
	}
	@Override
	public int getWheels() {
		return wheels;
	}	
}

class FactoryClassBicycle implements CycleFactory {	
	@Override
	public Cycle getCycle() {
		return new Bicycle();
	}
}

class FactoryClassUnicycle implements CycleFactory {	
	@Override
	public Cycle getCycle() {
		return new Unicycle();
	}
}

class FactoryClassTricycle implements CycleFactory {	
	@Override
	public Cycle getCycle() {
		return new Tricycle();
	}
}
