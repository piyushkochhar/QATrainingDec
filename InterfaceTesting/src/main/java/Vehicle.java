public abstract class Vehicle {

	protected int odometer;

	public int getOdometer() {
		return this.odometer;
	}

	public abstract void drive(int distance);

}
