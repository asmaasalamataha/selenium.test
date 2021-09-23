package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailespage;
import pages.SearchPage;

public class SearchProductUsingAutosuggest extends TestBase {

	SearchPage SearchPageObject;

	ProductDetailespage productDetailesObject;

	String productName = "Apple MacBook Pro 13-inch";

	@Test

	public void UsercansearchUsingAutosuggest() {

		SearchPageObject = new SearchPage(driver);
		SearchPageObject.searchUsingAutosuggest("MacB");
		productDetailesObject = new ProductDetailespage(driver);
		Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(), productName);

	}
}
