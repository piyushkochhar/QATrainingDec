package framework;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {

	private Select mappedElement;

	public DropDownList(WebElement mappedElement) {
		this.mappedElement = new Select(mappedElement);
	}

	public String getValue() {
		return this.mappedElement.getFirstSelectedOption().getText();
	}

	public String[] getOptions() {
		List<WebElement> allAvailableOptions = mappedElement.getOptions();
		String[] allOptionsListText = new String[allAvailableOptions.size()];

		for (int i = 0; i < allAvailableOptions.size(); i++) {
			allOptionsListText[i] = allAvailableOptions.get(i).getText();
		}
		return allOptionsListText;
	}

	public void setValue(String value) {
		this.mappedElement.selectByVisibleText(value);
		String actualValue = getValue();

		if (!actualValue.equals(value)) {
			throw new RuntimeException("The value '" + value + "' was not set.");
		}
	}

}
