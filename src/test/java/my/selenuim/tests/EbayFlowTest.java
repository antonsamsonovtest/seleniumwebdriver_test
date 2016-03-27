package my.selenuim.tests;

import my.selenuim.pages.ebay.EbayMainPage;

import org.testng.annotations.Test;

public class EbayFlowTest extends CommonTest {

	@Test
	public void searchFirstElectricGuitarPriceTest() {
		final EbayMainPage ebayMainPage = new EbayMainPage(getDriver());

		final String firstItemPrice = ebayMainPage.open().searchFor("Electric Guitar").getSearchResults().openItemByOrder(1).getItemPrice();

		System.out.println("First Electric Guitar price is " + firstItemPrice);
	}
}
