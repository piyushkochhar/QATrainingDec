package framework;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		setBrowserDriverPath("chromedriver.exe","chromedriver","webdriver.chrome.driver");
		setDriver(new ChromeDriver());
	}

}
