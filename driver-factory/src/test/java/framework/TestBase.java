package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class TestBase {

	private DriverManager manager;
	private WebDriver driver;

	protected WebDriver getDriver() throws Exception {
		return this.manager.getDriver();
	}

	protected DriverManager getDriverManager() throws Exception {
		return this.manager;
	}

	protected void setup() throws Exception {
		launchDriver();
	}

	protected void cleanup() throws Exception {
		manager.quitDriver();
	}

	private void setDriverManager() throws Exception {
		this.manager = DriverManagerFactory.getManager();
	}

	private void setDriver() throws Exception {
		this.driver = getDriverManager().getDriver();
	}

	private void launchDriver() throws Exception {
		setDriverManager();
		getDriverManager().createDriver();
		setDriver();
		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout, TimeUnit.SECONDS);
	}
}