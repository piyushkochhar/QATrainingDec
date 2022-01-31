package framework;

import java.util.HashMap;

public class DriverManagerFactory {

	public static DriverManager getManager() throws Exception {
		ConfigurationProvider myConfProvider = new ConfigurationProvider();
		HashMap<String, String> configProps = myConfProvider.getPropertiesFromResourceFile("config.properties");
		String browser = configProps.get("BrowserType");
		if (browser.equals("chrome")) {
			return new ChromeDriverManager();
		} else {
			return new EdgeDriverManager();
		}
	}
}
