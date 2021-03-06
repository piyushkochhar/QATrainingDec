package demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoqa.pages.DropDownListPage;
import framework.TestBase;

public class DropDownListTest extends TestBase {
	@Test
	public void canSelectDropDownListValue() {
		String expectedResultText = "Indigo";

		String actualResultText = new DropDownListPage(this.getDriver()).navigate().selectOption(expectedResultText)
				.responseText();

		Assert.assertEquals(actualResultText, expectedResultText,
				"the select option " + expectedResultText + " was not set");
	}

	@Test
	public void canGetAllOptions() {
		String[] expectedOptions = { "Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo",
				"Magenta", "Aqua" };

		String[] actualOptions = new DropDownListPage(this.getDriver()).navigate().getAllOptions();

		Assert.assertEquals(actualOptions, expectedOptions, "the option values are not equal");

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
