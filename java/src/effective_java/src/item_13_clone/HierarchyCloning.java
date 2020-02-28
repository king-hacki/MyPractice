package item_13_clone;

public class HierarchyCloning {

	public static void main(String[] args) {
		
		Node node = new Node(1, "Big");
		Tree original = new Tree(1, node);
		
		Tree clone = (Tree) original.clone();
		
		clone.getNode().setName("Small");
		
		System.out.println(clone.getNode().getName());
		System.out.println(original.getNode().getName());
		
	}

}

class Node implements Cloneable {
	
	int id;
	String name;
	
	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override 
	public Node clone () {
		try {
			return (Node) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
}

class Tree implements Cloneable {
	
	int number;
	Node node;
	
	@Override 
	public Tree clone() {
		try {
			Tree result = (Tree) super.clone();
			//	mutable can't be primitive
//			result.node = node.clone();						//	normal way
			result.setNode(result.getNode().clone());		// more complicated as for me
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	Tree (int number, Node node) {
		this.number = number;
		this.node = node;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	
	
}
