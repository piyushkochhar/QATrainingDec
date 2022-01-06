package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Slider {

	private WebElement mappedElement;
	private WebDriver driver;

	public Slider(WebElement mappedElement, WebDriver driver) {
		this.mappedElement = mappedElement;
		this.driver = driver;
	}

	public String getValue() {
		return this.mappedElement.getAttribute("value");
	}

	public void setValue(String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// sets slider value
		js.executeScript("javascript:document.querySelector('input').value = " + value);

		// sets textbox value
		js.executeScript("javascript:document.querySelector('input#sliderValue').value = " + value);

		String actualValue = getValue();

		if (!actualValue.equals(value)) {
			throw new RuntimeException("The value '" + value + "' was not set.");
		}
	}
}