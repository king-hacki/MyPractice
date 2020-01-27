package inner_classes;

public class Ex_16_anonyousCycleFactory {

	private static Cycle fabricaCycle (CycleFactory cf) {
		return cf.getCycle();
	}
	
	
	public static void main(String[] args) {

		Ex_16_anonyousCycleFactory.fabricaCycle(Bicycle.cycleFactory).move();
		((Bicycle) Ex_16_anonyousCycleFactory.fabricaCycle(Bicycle.cycleFactory)).getWheels();
		
	}

}

interface Cycle {
	void move();
}

interface CycleFactory {
	Cycle getCycle();
}

class Bicycle implements Cycle{

	private int wheels = 2;
	
	public int getWheels() {
		System.out.println("There are " + wheels + " wheels");
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	@Override
	public void move() {
		System.out.println("Bicycle move");
	}
	
	public static CycleFactory cycleFactory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Bicycle();
		}
		
	};
	
}

