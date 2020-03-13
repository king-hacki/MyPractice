package item_11_override_hashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Test {

	public static void main(String[] args) {
		
		Test t1 = new Test();
		Test t2 = t1;
		
		System.out.println(t1.equals(t2));		//	true
		System.out.println(t1.hashCode());		//	hash equal	
		System.out.println(t2.hashCode());		//	hash equal
		
		
		Map<PhoneNumber, String> m = new HashMap<>();
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");
		
		System.out.println(m.get(new PhoneNumber(707, 867, 5309)));		//	null if don't override hashCode() 
		System.out.println(new PhoneNumber(707, 867, 5309).equals(new PhoneNumber(707, 867, 5309)));		// true
		
		PhoneNumber phone = new PhoneNumber(1, 2, 3);
		PhoneNumber phone2 = phone;
		
		System.out.println(phone.hashCode());
		System.out.println(phone2.hashCode());
		System.out.println(phone.hashCode() == phone.hashCode());	//	true
		
	}	

	
}

class PhoneNumber {
	
	int x;
	int y;
	int z;
	
	public PhoneNumber(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// first we should override equals
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof PhoneNumber))
			return false;
		
		PhoneNumber phone = (PhoneNumber) o;
		
		if (!((this.x == phone.x) && (this.y == phone.y) && (this.z == phone.z))) 
			return false;
		
		return true;
		
	}
	
	// now we can override hashCode but it's bad because always 42
//	@Override 
//	public int hashCode () {
//		return 42;
//	}
	
	//	now it's good override hashCode() method
//	@Override 
//	public int hashCode () {
//		final int prime = 31;
//		int result = Integer.hashCode(x);
//		result = prime * result + Integer.hashCode(y);
//		result = prime * result + Integer.hashCode(z);
//		return result;
//	}
	
	//	generate good hash using Objects less productivity then under method
	//	because boxing primitive into array 
	@Override
	public int hashCode () {
		return Objects.hash(x, y, z);
	}
	
}

class ObjectPhoneNumber {
	
	PhoneNumber phone;
	Object object;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectPhoneNumber other = (ObjectPhoneNumber) obj;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	ObjectPhoneNumber(PhoneNumber phone){
		this.phone = phone;
	}

	
}



	


