import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BicycleTest {
	
	@Test
	public void canDriveBicycle() {
		Bicycle myBicycle = new Bicycle();
		
		myBicycle.drive(20);
		
		Assert.assertNotNull(myBicycle);
	}
	
	
	@Test
	public void canIncrementOdometer() {
		Bicycle myBike = new Bicycle();
		int miles = 20;

		myBike.drive(miles);

		Assert.assertEquals(myBike.getOdometer(),miles);
	}

}
