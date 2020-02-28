package item_13_clone;

public class SuperClone implements Cloneable {

	String name;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		SuperClone test =  new SuperClone("Hello i want be cloneable");
		SuperClone cloneTest = test.clone();
		
		System.out.println(cloneTest);
		
	}
	
	//	override clone() where we return super.clone() (Object)  
	@Override 
	public SuperClone clone()  {
		try {
			return (SuperClone) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	SuperClone(String name) {
		this.name = name;
	}

	public String toString () {
		return "name : " + name;
	}
}


