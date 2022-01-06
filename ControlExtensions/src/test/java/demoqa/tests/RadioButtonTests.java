package demoqa.tests;

import org.testng.annotations.Test;

import framework.TestBase;
import demoqa.pages.RadioButtonPage;

import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RadioButtonTests extends TestBase {

	@Test
	public void canSelectYesRadioButton() {
		String expectedResultText = "Yes";

		String resultLabelText = new RadioButtonPage(this.getDriver()).navigate().selectRadioButton("Yes")
				.getResultText();

		Assert.assertEquals(resultLabelText, expectedResultText, "the radio button was not selected");
	}

	@Test
	public void canSelectImpressiveRadioButton() {
		String expectedResultText = "Impressive";

		String resultLabelText = new RadioButtonPage(this.getDriver()).navigate().selectRadioButton("Impressive")
				.getResultText();

		Assert.assertEquals(resultLabelText, expectedResultText, "the radio button was not selected");
	}

	@Test
	public void cannotSelectNoRadioButton() {
		String expectedResultText = null;
		String resultLabelText = "No";

		try {
			resultLabelText = new RadioButtonPage(this.getDriver()).navigate().selectRadioButton("No").getResultText();
		} catch (NoSuchElementException e) {
			resultLabelText = null;
		}

		Assert.assertEquals(resultLabelText, expectedResultText, "the disabled radio button was selected");
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