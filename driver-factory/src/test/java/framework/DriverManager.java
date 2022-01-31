package framework;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	private WebDriver driver;

	public void createDriver() {

	}

	public WebDriver getDriver() {
		return this.driver;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void quitDriver() {
		this.driver.quit();
	}

	protected void setBrowserDriverPath(String windowsDriverFileName, String macDriverFileName, String browserProperty) {
		Path resourceDirectory = Paths.get("src", "test", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();

		// for windows
		Path driverFile = Paths.get(absolutePath, windowsDriverFileName);

		// for macOS
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			driverFile = Paths.get(absolutePath, macDriverFileName);
		}

		System.setProperty(browserProperty, driverFile.toFile().getAbsolutePath());
	}

}
