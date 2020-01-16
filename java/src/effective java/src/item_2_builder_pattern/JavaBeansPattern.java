package item_2_builder_pattern;

public class JavaBeansPattern {

	public static void main(String[] args) {
		
		System.out.println("[ + ] JavaBeans pattern start work : \n");
		
		Test c1 = new Test();
		Test c2 = new Test();
		Test c3 = new Test();
		Test c4 = new Test();
		Test c5 = new Test();
		Test c6 = new Test();
		Test c7 = new Test();
		Test c8 = new Test();
		
		c1.setEngine(3);
		
		c2.setEngine(3);
		c2.setMark(10);
		
		c3.setEngine(5);
		c3.setYear(7);
		c3.setMark(32);
		c3.setVechicle(54);
		c3.setName("Ford");
		c3.setOwner("John");
		
		c4.setMark(34);
		
		c6.setEngine(1);
		c6.setYear(1);
		c6.setMark(1);
		
		c7.setName("BMW");
		c7.setCountry("Germany");
		
		c8.setOwner("Karl");
		
		
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

class Test {
	
	private int engine 		= 0;
	private int year 		= 0;
	private int mark 		= 0;
	private int vechicle 	= 0;
	private String name 	= "0";
	private String country 	= "0";
	private String owner 	= "0";
	
	Test () {}
	
	public void setEngine (int val)		{ engine = val;}
	public void setYear (int val)		{ year = val;}
	public void setMark (int val)		{ mark = val;}
	public void setVechicle (int val)	{ vechicle = val;}
	public void setName (String val)	{ name = val;}
	public void setCountry (String val)	{ country = val;}
	public void setOwner (String val)	{ owner = val;}
	
	
	public String toString () {
		return  "[ + ]engine = " + engine + "\n[ + ]year = " + year + "\n[ + ]mark = " + mark + 
				"\n[ + ]vechicle = " + vechicle + "\n[ + ]name = " + name + 
				"\n[ + ]country = " + country + "\n[ + ]owner = " + owner + "\n\n";
	}
}