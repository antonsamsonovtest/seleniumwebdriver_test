package my.selenuim.pages.ebay;

import java.util.List;

import my.selenuim.pages.CommonPage;
import my.selenuim.pages.CustomContainer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbaySearchResultsPage extends CommonPage {

	@FindBy(id = "ListViewInner")
	private SearchResultsContainer searchResultsContainer;

	public EbaySearchResultsPage(final WebDriver driver) {
		super(driver);
	}

	public SearchResultsContainer getSearchResults() {
		return searchResultsContainer;
	}

	public static class SearchResultsContainer extends CustomContainer {

		@FindBy(xpath = "//*[@id='ListViewInner']/li/*[@class='lvtitle']/a")
		private List<WebElement> searchResults;

		public EbayParticularResultPage openItemByOrder(final int order) {
			searchResults.get(order - 1).click();
			return new EbayParticularResultPage(getDriver());
		}
	}
}
