
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
  

  @Test()
  public void canGetBrowserTypeFromFile() throws Exception {
	  ConfigurationProvider pv = new ConfigurationProvider();
	  HashMap<String, String> config = pv.getPropertiesFromResourceFile("config.properties");
	  String actualBrowserTypeValue = "chrome";
	  
	  String expectedBrowserTypeValue = config.get("BrowserType");
	  
	  Assert.assertEquals(actualBrowserTypeValue, expectedBrowserTypeValue);
  }
  
}
