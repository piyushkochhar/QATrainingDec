
public class Car {
	
	private int odometer;
	public LargeEngine engine;
	public String model;
	
	
	public Car(String model) {
		this.model = model;
		this.engine = new LargeEngine();
	}

	public int getOdometer() {
		return odometer;
	}

}
