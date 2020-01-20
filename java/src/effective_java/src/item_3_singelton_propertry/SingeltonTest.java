package item_3_singelton_propertry;

public class SingeltonTest {

	public static void main(String[] args) {
		
		SingeltonPublicInstance s1 = SingeltonPublicInstance.INSTANCE;		//		- not lazy
		SingeltonStaticFactory s2 = SingeltonStaticFactory.getInstance();	//		+ lazy
		SingeltonEnum s3 = SingeltonEnum.INSTANCE;							//		- not lazy
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}

}

class SingeltonPublicInstance {
	
	String text;
	
	public static final SingeltonPublicInstance INSTANCE = new SingeltonPublicInstance("Singelton with public instance");
	private SingeltonPublicInstance(String text) { 
		this.text = text;
	}
	
	public String toString() {
		return "[ + ] " + text;
}
}

class SingeltonStaticFactory {
	String text;
	
	private static final SingeltonStaticFactory INSTANCE = new SingeltonStaticFactory("Singelton with static factory");
	private SingeltonStaticFactory(String text) {
		this.text = text;
	}
	
	static SingeltonStaticFactory getInstance() {
		return INSTANCE;
	}
	
	public String toString() {
		return "[ + ] " + text;
	}
}

enum SingeltonEnum {
	INSTANCE("Create singelton using enum");
	
	String text;
	
	private SingeltonEnum (String text) {
		this.text = text;
	}
	
	public String toString() {
		return "[ + ] " + text;
	}
	
}


