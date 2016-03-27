package my.selenuim.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTest {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
