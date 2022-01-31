package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.TestBase;

public class DriverManagerTest extends TestBase {

	@Test
	public void canOpenBrowser() throws Exception {
		String expectedURL = "http://automationpractice.com/index.php";
		
		this.getDriver().navigate().to(expectedURL);
		String actualURL = this.getDriver().getCurrentUrl();

		Assert.assertEquals(actualURL, expectedURL);
	}

	@BeforeMethod
	public void setup() throws Exception {
		super.setup();
	}

	@AfterMethod
	public void cleanup() throws Exception {
		super.cleanup();
	}
}
