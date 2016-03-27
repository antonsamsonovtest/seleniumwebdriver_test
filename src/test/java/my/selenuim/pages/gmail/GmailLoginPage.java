package my.selenuim.pages.gmail;

import my.selenuim.pages.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends CommonPage {

	@FindBy(id = "Email")
	private WebElement emailInput;

	@FindBy(id = "Passwd")
	private WebElement passwdInput;

	@FindBy(id = "next")
	private WebElement nextButton;

	@FindBy(id = "signIn")
	private WebElement signInButton;

	@FindBy(xpath = "//a[contains(@href, 'accounts.google.com/SignOutOptions') and contains(@title, 'Google Account')]")
	private WebElement userIcon;

	@FindBy(xpath = "//*[@class='error-msg' and @role='alert'][ancestor::*/div[@id='password-shown']]")
	private WebElement passwdWarningMessage;

	public GmailLoginPage(final WebDriver driver) {
		super(driver);
	}

	public GmailLoginPage open() {
		getDriver().get("http://gmail.com");
		return this;
	}

	public GmailLoginPage login(String email, String pass) {
		emailInput.sendKeys(email);
		nextButton.click();
		passwdInput.sendKeys(pass);
		signInButton.click();
		return this;
	}

	public boolean isSuccessfullyLoggedIn() {
		return userIcon.isDisplayed();
	}

	public String getPasswordWarningMessage() {
		return passwdWarningMessage.getText();
	}

}
