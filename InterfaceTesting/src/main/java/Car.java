public class Car extends Vehicle{

	public IEngine engine;
	public String model;


	public Car(String model) {
		this.model = model;
		this.engine = new LargeEngine();
	}

	public Car(String model, IEngine engine) {
		this.model = model;
		this.engine = engine;

	}

	public void start() {
		this.engine.start();
	}

	@Override
	public void drive(int distance) {
		this.odometer += distance;

	}

}
