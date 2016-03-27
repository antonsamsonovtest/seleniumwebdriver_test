package my.selenuim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomContainer {

	public WebElement wrappedElement;
	public WebDriver driver;

	public CustomContainer() {
	}

	public void init(final WebElement wrappedElement, final WebDriver driver) {
		this.wrappedElement = wrappedElement;
		this.driver = driver;
	}

	public WebElement getWrappedElement() {
		return this.wrappedElement;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
