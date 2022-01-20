package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import framework.Helpers;
import framework.Hyperlink;

public class HyperlinksPage extends PageObjectBase {

	private final String url = "https://demoqa.com/links";

	@FindBy(how = How.ID, using = "created")
	private WebElement hyperlinkElement;

	@FindBy(how = How.ID, using = "linkResponse")
	private WebElement responseText;

	public HyperlinksPage(WebDriver driver) {
		super(driver);
	}

	public HyperlinksPage clickHyperlink(String link) {
		new Hyperlink(hyperlinkElement).click(link);
		return this;

	}

	public HyperlinksPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}

	public String responseText() {
		String fullResultText = responseText.getText();
		String last = Helpers.getTextAfter(fullResultText, " ");
		return last;
	}

}
