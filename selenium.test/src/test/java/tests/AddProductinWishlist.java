package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddWishListPage;
import pages.ProductDetailespage;
import pages.SearchPage;

public class AddProductinWishlist extends TestBase{
	
	SearchPage SearchPageObject;
	ProductDetailespage productDetailesObject;
	String productName = "Apple MacBook Pro 13-inch";
	AddWishListPage AddWishListPageObject ;
	
	@Test(priority = 1, alwaysRun = true)
	public void UsercansearchUsingAutosuggest() {

		try {
			SearchPageObject = new SearchPage(driver);
			SearchPageObject.searchUsingAutosuggest("MacB");
			productDetailesObject = new ProductDetailespage(driver);
			Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(), productName);

		} catch (Exception e) {

			System.out.println("Error occured " + e.getMessage());
		}
	}

	@Test(priority = 2, alwaysRun = true)
	
	public void UsercansearchAddProducttoWishlist() {
	
		productDetailesObject = new ProductDetailespage(driver);
		productDetailesObject.CanAddProducttoWishList();
		AddWishListPageObject = new AddWishListPage(driver);
		driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
	    Assert.assertTrue(AddWishListPageObject.Wishlistheader.isDisplayed());
	   // Assert.assertTrue(AddWishListPageObject.ProductCell.getText().contains(productName));
	
}
	
	
	@Test(priority = 3, alwaysRun = true)
	
	public void UsercansearchRemoveProductFromWishlist() {
	
		AddWishListPageObject = new AddWishListPage(driver);
		AddWishListPageObject.RemoveProductFromWishlist();
	Assert.assertTrue(AddWishListPageObject.TxtTovalidateRemovefromWishlist.getText().contains("The wishlist is empty!"));
	
	
}
}
