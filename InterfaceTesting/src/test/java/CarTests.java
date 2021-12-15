import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CarTests {

	@Test
	public void canBuildCar() {
		Car myCorvette = new Car("Corvette");

		myCorvette.start();

		Assert.assertNotNull(myCorvette);

	}

	@Test
	public void canIncrementOdometer() {
		Car myTesla = new Car("Tesla Model X");
		int miles = 20;

		myTesla.drive(miles);

		Assert.assertEquals(myTesla.getOdometer(),miles);
	}

	@Test
	public void canBuildSmallEngineCar() {
		SmallEngine se = new SmallEngine();
		Car myFord = new Car("Ford Focus", se);
		int expectedCylinderCount = 4;

		int actualCylinderCount = myFord.engine.getCylinderCount();
		myFord.start();

		Assert.assertEquals(expectedCylinderCount, actualCylinderCount);
	}

	@Test
	public void canBuildLargeEngineCar() {
		LargeEngine le = new LargeEngine();
		Car myDodge = new Car("Dodge Ram", le);
		int expectedCylinderCount = 8;

		int actualCylinderCount = myDodge.engine.getCylinderCount();
		myDodge.start();

		Assert.assertEquals(expectedCylinderCount, actualCylinderCount);
	}

	@Test
	public void canBuildConvertibleCar() {
		Convertible myMustang = new Convertible("Ford Mustang");
		int expectedCylinderCount = 4;

		int actualCylinderCount = myMustang.engine.getCylinderCount();
		myMustang.start();

		Assert.assertEquals(expectedCylinderCount, actualCylinderCount);

	}

	@Test
	public void canConvertibleCarRaiseTop() {
		Convertible myMustang = new Convertible("Ford Mustang");
		String expectedTopStatus = "Up";

		myMustang.raise();
		String actualTopStatus = myMustang.getTopStatus();

		Assert.assertEquals(expectedTopStatus, actualTopStatus);
	}

	@Test
	public void canConvertibleCarLowerTop() {
		Convertible myMustang = new Convertible("Ford Mustang");
		String expectedTopStatus = "Down";

		myMustang.lower();
		String actualTopStatus = myMustang.getTopStatus();

		Assert.assertEquals(expectedTopStatus, actualTopStatus);
	}

}
