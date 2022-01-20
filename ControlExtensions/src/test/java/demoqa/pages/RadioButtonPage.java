package demoqa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.RadioButton;

public class RadioButtonPage extends PageObjectBase {

	private final String url = "https://demoqa.com/radio-button";

	@FindBy(how = How.CSS, using = "input[name='like']")
	private List<WebElement> radioButtonElements;

	@FindBy(how = How.CLASS_NAME, using = "text-success")
	private List<WebElement> resultText;

	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}

	public RadioButtonPage selectRadioButton(String label) {
		new RadioButton(radioButtonElements, driver).select(label);
		return this;

	}

	public RadioButtonPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}

	public String getResultText() {
		return resultText.size() > 0 ? resultText.get(0).getText() : null;
	}

}
