package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import framework.Slider;

public class SliderPage extends PageObjectBase {
	private final String url = "https://demoqa.com/slider";

	@FindBy(how = How.CSS, using = "input[type='range']")
	private WebElement sliderElement;

	@FindBy(how = How.ID, using = "sliderValue")
	private WebElement sliderValue;

	public SliderPage(WebDriver driver) {
		super(driver);
	}

	public SliderPage setSlider(String value) {
		new Slider(sliderElement, driver).setValue(value);
		return this;

	}

	public SliderPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}

	public String responseText() {
		return sliderValue.getAttribute("value");
	}

}
