package demoqa.tests;

import org.testng.annotations.Test;
import framework.TestBase;
import demoqa.pages.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SliderTests extends TestBase {

	@Test
	public void canSetSliderValue() {
		String[] values = { "80", "17", "0", "100" };
		String expectedResultText;
		String resultSliderValue;

		for (String value : values) {
			expectedResultText = value;
			resultSliderValue = new SliderPage(this.getDriver()).navigate().setSlider(value).responseText();

			Assert.assertEquals(resultSliderValue, expectedResultText,
					"the slider value " + expectedResultText + " was not set");

		}

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