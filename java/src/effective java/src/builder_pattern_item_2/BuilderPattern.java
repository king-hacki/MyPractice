package builder_pattern_item_2;

public class BuilderPattern {

	public static void main(String[] args) {
		
		System.out.println("[ + ] Builder pattern start work : ");
		
		Car c1 = new Car.Builder().engine(3).build();
		Car c2 = new Car.Builder().engine(3).mark(10).build();
		Car c3 = new Car.Builder().engine(5).year(7).mark(32).vechicle(54).name("Ford").owner("John").build();
		Car c4 = new Car.Builder().mark(34).build();
		Car c5 = new Car.Builder().build();
		Car c6 = new Car.Builder().engine(1).year(1).mark(1).build();
		Car c7 = new Car.Builder().name("BMW").country("Germany").build();
		Car c8 = new Car.Builder().owner("Karl").build();
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
	}

}

class Car {
	
	private int engine;
	private int year;
	private int mark;
	private int vechicle;
	private String name;
	private String country;
	private String owner;
	
	public static class Builder {
		
		private int engine 		= 0;
		private int year 		= 0;
		private int mark 		= 0;
		private int vechicle 	= 0;
		private String name 	= "0";
		private String country 	= "0";
		private String owner 	= "0";
		
		Builder(){}
		
		public Builder engine (int var) {
			engine = var;
			return this;
		}
		
		public Builder year (int var) {
			year = var;
			return this;
		}
		
		public Builder mark (int var) {
			mark = var;
			return this;
		}
		
		public Builder vechicle (int var) {
			vechicle  = var;
			return this;
		}
		
		public Builder name (String var) {
			name = var;
			return this;
		}
		
		public Builder country (String var) {
			country = var;
			return this;
		}
		
		public Builder owner (String var) {
			owner = var;
			return this;
		}
		
		public Car build() {
			return new Car(this);
		}
			
	}
	
	public Car (Builder builder) {
	
		engine = builder.engine;
		year = builder.year;
		mark = builder.mark;
		vechicle = builder.vechicle;
		name = builder.name;
		country = builder.country;
		owner = builder.owner;
	}
	
	public String toString () {
		return  "[ + ]engine = " + engine + "\n[ + ]year = " + year + "\n[ + ]mark = " + mark + 
				"\n[ + ]vechicle = " + vechicle + "\n[ + ]name = " + name + 
				"\n[ + ]country = " + country + "\n[ + ]owner = " + owner + "\n\n";
	}
}