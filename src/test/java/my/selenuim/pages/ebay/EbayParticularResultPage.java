package my.selenuim.pages.ebay;

import my.selenuim.pages.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayParticularResultPage extends CommonPage {

	@FindBy(id = "prcIsum")
	private WebElement itemPrice;

	public EbayParticularResultPage(final WebDriver driver) {
		super(driver);
	}

	public String getItemPrice() {
		return itemPrice.getText();
	}
}
