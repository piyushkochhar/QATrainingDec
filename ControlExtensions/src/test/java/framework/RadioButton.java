package framework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RadioButton {

	private List<WebElement> radioList;
	private WebElement mappedElement;
	private WebDriver driver;

	public RadioButton(List<WebElement> radioList, WebDriver driver) {
		this.radioList = radioList;
		this.driver = driver;
	}

	public String getSelected() {
		for (WebElement radio : radioList) {
			if (radio.isSelected()) {
				this.mappedElement = radio;
			}
		}
		return this.mappedElement.getAttribute("id");
	}

	public void select(String label) {

		for (WebElement radio : radioList) {
			if (radio.getAttribute("id").equals(label.toLowerCase() + "Radio")) {
				this.mappedElement = radio;
			}
		}

		Actions action = new Actions(driver);
		action.moveToElement(this.mappedElement).click().perform();

		if (!this.mappedElement.isSelected() && this.mappedElement.isEnabled()) {
			throw new RuntimeException("The radio button'" + label + "' was not selected.");
		}

	}
}