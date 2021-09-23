package tests;

import org.testng.Assert;
import org.testng.annotations.Test;



import pages.MenuPage;
import pages.ProductDetailespage;
import pages.SearchPage;


public class ChangeCurrencyTest extends TestBase {

	ProductDetailespage productDetailesObject;
	String productName = "Apple MacBook Pro 13-inch";
	MenuPage menuPageObject;
	SearchPage SearchPageObject;

	@Test(priority = 1, alwaysRun = true)

	public void UserCanChossetheCurrency() {

		menuPageObject = new MenuPage(driver);
		menuPageObject.changeCurrency();
		productDetailesObject = new ProductDetailespage(driver);

	}

	@Test(priority = 2, alwaysRun = true)
	public void UsercansearchUsingAutosuggest() {

		try {
			SearchPageObject = new SearchPage(driver);
			SearchPageObject.searchUsingAutosuggest("MacB");
			productDetailesObject = new ProductDetailespage(driver);
			Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(), productName);
			Assert.assertTrue(productDetailesObject.productpricelabel.getText().contains("€"));
		} catch (Exception e) {

			System.out.println("Error occured " + e.getMessage());
		}
	}
}
