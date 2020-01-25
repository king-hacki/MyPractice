package polymorphism;

public class Ex_16_states {

	public static void main(String[] args) {
		
		AlertStatus status = new AlertStatus();
		
		status.showAlert();
		status.changeGood();
		status.showAlert();
		status.changeBad();
		status.showAlert();
		status.changeMiddle();
		status.showAlert();
	}

}

class Starship {
	public void alert() {}
}

class AlertMiddle extends Starship {
	public void alert() {
		System.out.println("Alert Middle");
	}
}
class AlertGood extends Starship {
	public void alert() {
		System.out.println("Alert Good");
	}	
}

class AlertBad extends Starship {
	public void alert() {
		System.out.println("Alert Bad");
	}
}

class AlertStatus {
	Starship alert = new AlertMiddle(); 
	
	public void changeBad () { alert = new AlertBad();}
	public void changeGood () { alert = new AlertGood();}
	public void changeMiddle () { alert = new AlertMiddle();}
	
	public void showAlert () {
		alert.alert();
	}
}
