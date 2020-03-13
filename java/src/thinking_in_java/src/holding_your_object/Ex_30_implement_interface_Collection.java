package holding_your_object;

import java.util.Collection;
import java.util.Iterator;

/*
 * Exercise 30: (5) 
 * Modify CollectionSequence.java so that it does not inherit from AbstractCollection, 
 * but instead implements Collection.
 */

public class Ex_30_implement_interface_Collection {

	public static void main(String[] args) {

		Pet [] array = {
					new Pet("A"), 
					new Pet("B"), 
					new Pet("C"), 
					new Pet("D"), 
					new Pet("E"), 
					new Pet("F")
				};
		
		ImplemetCollection test = new ImplemetCollection(array);
		
		
		
		System.out.println("Size : " + test.size());							//	6
		System.out.println("IsEmpty : " + test.isEmpty());						//	false
		System.out.println("Contains : " + test.contains(new Pet("A")));		//	true
		System.out.println("Contains : " + test.contains(new Pet("Q")));		//	false
		
	}

}

class Pet {
	
	String name;
	
	public Pet(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Pet other = (Pet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
 }

class ImplemetCollection implements Collection<Pet> {

	Pet [] array;
	
	public ImplemetCollection (Pet [] array) {
		this.array = array;
	}
	
	
	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0 ? true : false;
	}

	@Override
	public boolean contains(Object o) {
		
		if (!(o instanceof Pet))
			return false;
		
		for (Pet p : array)
			if (((Pet)o).equals(p))
				return true;
		
		return false;
	}

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {

			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < array.length;
			}

			@Override
			public Pet next() {
				return array[index++];
			}
			
		};
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Pet e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Pet> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}