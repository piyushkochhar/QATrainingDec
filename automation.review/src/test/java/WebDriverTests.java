import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebDriverTests {

	WebDriver driver;

	@Test
	public void canLaunchWebDriver() {
		// Arrange

		// Act

		// Assert
		Assert.assertNotNull(driver, "WebDriver not found");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
