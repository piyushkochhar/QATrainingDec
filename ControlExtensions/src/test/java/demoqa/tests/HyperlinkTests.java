package demoqa.tests;

import org.testng.annotations.Test;
import framework.TestBase;
import demoqa.pages.HyperlinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HyperlinkTests extends TestBase {

	@Test
	public void canSelectRadioButton() {
		String expectedResultText = "Created";

		String resultLabelText = new HyperlinksPage(this.getDriver()).navigate().clickHyperlink(expectedResultText)
				.responseText();

		Assert.assertEquals(resultLabelText, expectedResultText,
				"the hyperlink " + expectedResultText + " was not clicked");
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