package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import framework.DropDownList;

public class DropDownListPage extends PageObjectBase {
	private final String url = "https://demoqa.com/select-menu";

	@FindBy(how = How.ID, using = "oldSelectMenu")
	private WebElement selectElement;

	public DropDownListPage(WebDriver driver) {
		super(driver);
	}

	public DropDownListPage selectOption(String value) {
		new DropDownList(selectElement).setValue(value);
		return this;
	}

	public DropDownListPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}

	public String responseText() {
		DropDownList ddl = new DropDownList(selectElement);
		return ddl.getValue();
	}

	public String[] getAllOptions() {
		DropDownList ddl = new DropDownList(selectElement);
		return ddl.getOptions();
	}

}
