package framework;

import org.openqa.selenium.edge.*;

public class EdgeDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		setBrowserDriverPath("msedgedriver.exe","msedgedriver","webdriver.edge.driver");
		setDriver(new EdgeDriver());
	}
}
