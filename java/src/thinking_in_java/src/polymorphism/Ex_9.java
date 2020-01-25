package polymorphism;

//TIJ4 Chapter Polymorphism, Exercise 9, page 289
/* Create an inheritance hierarchy of Rodent:Mouse, Gerbil, Hamster, etc. In the
* base class, provide methods that are common to all Rodents, and override these
* in the derived classes to perform different behaviors depending on the
* specific type of Rodent. Create an array of Rodent, fill it with different
* specific types of Rodents, and call your base-class methods to see what 
* happens.
*/
public class Ex_9 {
	
	static Animal [] animals = {
			new Bird(),
			new Mammal(),
			new Fish(),
			new Fish(),
			new Bird(),
			new Fish(),
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


class Animal {
	
	void move () {
		System.out.println("Animal move");
	}
	void life () {
		System.out.println("Animal life");
	}
	
}

class Bird extends Animal {
	void move () {
		System.out.println("Bird move");
	}
	
	void life () {
		System.out.println("Bird life");
	}
}

class Mammal extends Animal {
	void move () {
		System.out.println("Mammal move");
	}
	void life () {
		System.out.println("Animal life");
	}
}

class Fish extends Animal {
	void move () {
		System.out.println("Fish move");
	}
	void life () {
		System.out.println("Fish life");
	}
}









