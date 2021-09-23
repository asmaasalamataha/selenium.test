package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "small-searchterms")
	WebElement searchtextBox;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchbutton;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;

	@FindBy(id = "ui-id-1")
	List<WebElement> productlist;

	public void productsearch(String productName) {

		setTextElement(searchtextBox, productName);
		clickbutton(searchbutton);
	}

	public void OpenProductDetails() {

		clickbutton(productTitle);

	}

	public void searchUsingAutosuggest(String searchtxt) {

		setTextElement(searchtextBox, searchtxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		productlist.get(0).click();

	}
}
