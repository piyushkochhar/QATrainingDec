public class Convertible extends Car{

	private String topStatus;

	public Convertible(String model) {
		super(model);
		this.engine = new SmallEngine();
	}


	public Convertible(String model, IEngine engine) {
		super(model, engine);
	}

	public String getTopStatus() {
		return topStatus;
	}

	public void raise() {
		this.topStatus = "Up";

	}

	public void lower() {
		this.topStatus = "Down";

	}


}