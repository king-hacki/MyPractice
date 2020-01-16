package builder_pattern_item_2;

public class TelescopeConstructorPattern {

	public static void main(String[] args) {
		
		System.out.println("[ + ] TelescopeConstrucctor pattern start work : \n");
		
		CarExample c1 = new CarExample(3);
		CarExample c2 = new CarExample(3, 0, 10);
		CarExample c3 = new CarExample(5, 7, 32, 54, "Ford", "", "John");
		CarExample c4 = new CarExample(0, 0, 34);
		CarExample c5 = new CarExample(0);		
		CarExample c6 = new CarExample(1, 1, 1);
		CarExample c7 = new CarExample(0, 0, 0, 0, "BMW", "Germany");
		CarExample c8 = new CarExample(0, 0, 0, 0, "", "", "Karl");
		
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

class CarExample {
	
	private int engine;
	private int year;
	private int mark;
	private int vechicle;
	private String name;
	private String country;
	private String owner;
	
	
	public CarExample (int engine) {
		this(engine, 0);
	}
	
	public CarExample (int engine, int year) {
		this(engine, year, 0);
	}
	
	public CarExample (int engine, int year, int mark) {
		this(engine, year, mark, 0);
	}
	
	public CarExample (int engine, int year, int mark, int vechicle) {
		this(engine, year, mark, vechicle, "0");
	}

	public CarExample (int engine, int year, int mark, int vechicle, String name) {
		this(engine, year, mark, vechicle, name, "0");
	}

	public CarExample (int engine, int year, int mark, int vechicle, String name, String country) {
		this(engine, year, mark, vechicle, name, country, "0");
	}

	public CarExample (int engine, int year, int mark, int vechicle, String name, String country, String owner) {
		this.engine = engine;
		this.year = year;
		this.mark = mark;
		this.vechicle = vechicle;
		this.name = name;
		this.country = country;
		this.owner = owner;
	}

	public String toString () {
		return  "[ + ]engine = " + engine + "\n[ + ]year = " + year + "\n[ + ]mark = " + mark + 
				"\n[ + ]vechicle = " + vechicle + "\n[ + ]name = " + name + 
				"\n[ + ]country = " + country + "\n[ + ]owner = " + owner + "\n\n";
	}
	
}
