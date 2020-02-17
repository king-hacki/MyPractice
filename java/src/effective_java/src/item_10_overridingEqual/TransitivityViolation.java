package item_10_overridingEqual;

public class TransitivityViolation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p = new Point(1, 2);
		
		
		ColorPointSymmetryViolationCause cps = new ColorPointSymmetryViolationCause(1, 2, "Red");
		
		//	Symmetry violation
		System.out.println(p.equals(cps));		//	true
		System.out.println(cps.equals(p));		//	false ---->	symmetry
		
		System.out.println("------------");		
		
		ColorPointTransitivityViolationCause  cpt1 = new ColorPointTransitivityViolationCause(1, 2, "Red");
		ColorPointTransitivityViolationCause  cpt2 = new ColorPointTransitivityViolationCause(1, 2, "Blue");
		
		//	Transitivity violation
		System.out.println(cpt1.equals(p));			//	true
		System.out.println(p.equals(cpt2));			//	true
		System.out.println(cpt1.equals(cpt2));		// 	false ---> transitivity
		
		System.out.println("------------");		
		
		ColorPointWithoutViolation cpr1 = new ColorPointWithoutViolation(1, 2, new Color("Red"));
		ColorPointWithoutViolation cpr2 = new ColorPointWithoutViolation(1, 2, new Color("Blue"));
		
		//	Right
		System.out.println(cpr1.equals(p));			//	false
		System.out.println(p.equals(cpr1));			//	false
		System.out.println(p.equals(cpr2));			//	false
		System.out.println(cpr2.equals(p));			//	false
		System.out.println(cpr1.equals(cpr2));		// 	false 
	}
}

class Point {
	
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {

		if (!(o instanceof Point))
			return false;
					
		Point p = (Point)o;
		return this.x == p.x && this.y == p.y;
	}	
	
	
}

class ColorPointSymmetryViolationCause extends Point {

	String color;		// how to realize equals in subclass when there is equals in super class
	
	public ColorPointSymmetryViolationCause(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	@Override
	public boolean equals(Object o) {

		if (!(o instanceof ColorPointSymmetryViolationCause))
			return false;
		
		//	called symmetry violation 
		return super.equals(o) && ((ColorPointSymmetryViolationCause) o).color == this.color;
		
	}
}

class ColorPointTransitivityViolationCause extends Point {

	String color;
	
	public ColorPointTransitivityViolationCause(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Point))
			return false;
		
		if (!(o instanceof ColorPointTransitivityViolationCause))
			return o.equals(this);
		
		return super.equals(o) && ((ColorPointTransitivityViolationCause) o).color == this.color;
		
	}

}

class ColorPointWithoutViolation{
	
	Color color;
	Point point;
	
	public ColorPointWithoutViolation(int x, int y, Color c) {		
		point = new Point (x, y);
		this.color = c;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof ColorPointWithoutViolation))
			return false; 
		
		ColorPointWithoutViolation cp = (ColorPointWithoutViolation) o;
		
		return cp.point.equals(this.point) && cp.color.equals(this.color);
	}
}

class Color {
	
	String color;
	
	Color(String color){
		this.color = color;
	}
	
}
Float 









	
