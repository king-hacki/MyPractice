package polymorphism;

//TIJ4 Chapter Polymorphism, Exercise 9, page 289
/* Create an inheritance hierarchy of Rodent:Mouse, Gerbil, Hamster, etc. In the
* base class, provide methods that are common to all Rodents, and override these
* in the derived classes to perform different behaviors depending on the
* specific type of Rodent. Create an array of Rodent, fill it with different
* specific types of Rodents, and call your base-class methods to see what 
* happens.
*/

//TIJ4 Chapter Polymorphism, Exercise 12, page 298
/* Modify exercise 9 so that it demonstrates the order of initialization of the 
* base classes and derived classes. Now add member objects to both the base and
* derived classes, and show the order in which their initialization occurs during
* construction.
*/

public class Ex_9_12_orderOfInitializeConstructors {
	
	public static Animal [] animals = {
			new Mammal(),
			new Bird(),
			new Mammal(),
			new Fish()
	};
	
	static void callAnimal() {
		for (Animal animal : animals) {
			animal.move();
			animal.life();
		}
			
	}
	
	public static void main(String[] args) {
		callAnimal();
	}

}


class Characteristic {
	private String ch;
	Characteristic (String ch) {
		this.ch = ch;
		System.out.println(this.ch);
	}
}

class Animal {
	
	Characteristic charac = new Characteristic("All animal's characteristics");
	
	void move () {
		System.out.println("Animal move");
	}
	void life () {
		System.out.println("Animal life");
	}	
	Animal () {
		System.out.println("Animal has been created");
	}
}

class Bird extends Animal {
	void move () {
		System.out.println("Bird move");
	}
	void life () {
		System.out.println("Bird life");
	}
	Bird () {
		System.out.println("Bird has been created");
	}
	
	public static Bird getMammal () {
		return new Bird();
	}
}

class Mammal extends Animal {
	void move () {
		System.out.println("Mammal move");
	}
	void life () {
		System.out.println("Mammal life");
	}
	Mammal () {
		System.out.println("Mammal has been created");
	}
	
	public static Mammal getMammal () {
		return new Mammal();
	}
}

class Fish extends Animal {
	void move () {
		System.out.println("Fish move");
	}
	void life () {
		System.out.println("Fish life");
	}
	Fish () {
		System.out.println("Fish has been created");
	}
	
	public static Fish getMammal () {
		return new Fish();
	}
}









