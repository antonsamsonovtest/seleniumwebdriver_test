package my.selenuim.pages;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

public class CustomFieldDecorator extends DefaultFieldDecorator {

	private WebDriver driver;

	public CustomFieldDecorator(SearchContext searchContext) {
		super(new DefaultElementLocatorFactory(searchContext));
		driver = (WebDriver) searchContext;
	}

	public CustomFieldDecorator(SearchContext searchContext, WebDriver driver) {
		super(new DefaultElementLocatorFactory(searchContext));
		this.driver = driver;
	}

	@SuppressWarnings("unchecked")
	public Object decorate(ClassLoader loader, Field field) {
		if (CustomContainer.class.isAssignableFrom(field.getType())) {
			final WebElement wrappedElement = proxyForLocator(loader, factory.createLocator(field));
			CustomContainer container = null;
			try {
				container = ((Class<? extends CustomContainer>) field.getType()).newInstance();
			} catch (Exception e) {
				System.err.println("Container creation error. Class: " + field.getType() + e);
			}
			PageFactory.initElements(new CustomFieldDecorator(wrappedElement, driver), container);
			container.init(wrappedElement, driver);
			return container;
		}
		return super.decorate(loader, field);
	}
}
