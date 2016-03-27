package my.selenuim.tests;

import my.selenuim.pages.gmail.GmailLoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleFlowTest extends CommonTest {

	private final static String EMAIL = "someemail11223344@gmail.com";
	private final static String PASS = "$someemail1234";

	@Test
	public void loginWithValidCredsTest() {
		final GmailLoginPage gmailLoginPage = new GmailLoginPage(getDriver());

		Assert.assertTrue(gmailLoginPage.open().login(EMAIL, PASS).isSuccessfullyLoggedIn(), "Unable to login with valid username {"
				+ EMAIL + "} and password {" + PASS + "}. ");
	}

	@Test
	public void loginWithInvalidPasswordTest() {
		final String expectedWarningMessage = "The email and password you entered don't match.";

		final GmailLoginPage gmailLoginPage = new GmailLoginPage(getDriver());

		Assert.assertEquals(gmailLoginPage.open().login(EMAIL, "wrongpass").getPasswordWarningMessage(), expectedWarningMessage,
				"The error message expected to appear when login with invalid password.");
	}

	@Test
	public void loginWithEmptyPasswordTest() {
		final String expectedWarningMessage = "Please enter your password.";

		final GmailLoginPage gmailLoginPage = new GmailLoginPage(getDriver());

		Assert.assertEquals(gmailLoginPage.open().login(EMAIL, "").getPasswordWarningMessage(), expectedWarningMessage,
				"The error message expected to appear when login with empty password.");
	}
}
