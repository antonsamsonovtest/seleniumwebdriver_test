package my.selenuim.pages.ebay;

import my.selenuim.pages.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayMainPage extends CommonPage {

	@FindBy(id = "gh-ac")
	private WebElement searchInput;

	@FindBy(xpath = "//*[@id='gh-btn' and @type='submit']")
	private WebElement searchButton;

	public EbayMainPage(final WebDriver driver) {
		super(driver);
	}

	public EbayMainPage open() {
		getDriver().get("http://ebay.com/");
		return this;
	}

	public EbaySearchResultsPage searchFor(final String whatToSearchFor) {
		searchInput.sendKeys(whatToSearchFor);
		searchButton.click();
		return new EbaySearchResultsPage(getDriver());
	}
}
