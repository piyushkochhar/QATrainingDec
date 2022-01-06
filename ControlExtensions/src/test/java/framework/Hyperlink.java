package framework;

import org.openqa.selenium.WebElement;

public class Hyperlink {

	private WebElement mappedElement;

	public Hyperlink(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public String getClicked() {
		return this.mappedElement.getText();
	}

	public void click(String label) {
		this.mappedElement.click();
		String actualValue = this.getClicked();

		if (!actualValue.equals(label)) {
			throw new RuntimeException("The value '" + label + "' was not set.");
		}
	}
}