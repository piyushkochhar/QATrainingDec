package demoqa.tests;

import org.testng.annotations.Test;
import framework.TestBase;
import demoqa.pages.HyperlinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class HyperlinkTests extends TestBase {

	@Test
	public void canSelectRadioButton() {
		String expectedResultText = "Created";

		String resultLabelText = new HyperlinksPage(this.getDriver()).navigate().clickHyperlink(expectedResultText)
				.responseText();

		Assert.assertEquals(resultLabelText, expectedResultText,
				"the hyperlink " + expectedResultText + " was not clicked");
	}
	
	@BeforeSuite
	 public void beforeSuite() {
        System.out.println("Before Suite Setup");
    }   
	
	@AfterSuite
	 public void afterSuite() {
       System.out.println("After Suite Teardown");
   }   

	@BeforeMethod
	public void setup() {
		super.setup();
	}

	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}
}