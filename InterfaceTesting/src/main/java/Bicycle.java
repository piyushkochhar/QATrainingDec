public class Bicycle extends Vehicle{
	
	@Override
	public void drive(int distance) {
		System.out.println("Driving Bicycle");
		this.odometer += distance;
	}

}