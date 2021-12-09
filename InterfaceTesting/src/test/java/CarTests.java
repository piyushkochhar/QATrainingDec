import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CarTests {

	@Test
	public void canBuildCar() {
		Car myCorvette = new Car("Corvette");
		
		myCorvette.engine.start();
		
		Assert.assertNotNull(myCorvette);
		
	}
}
