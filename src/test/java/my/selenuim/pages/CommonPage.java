package my.selenuim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

	private WebDriver driver;

	public CommonPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
