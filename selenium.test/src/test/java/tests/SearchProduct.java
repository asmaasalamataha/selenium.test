package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailespage;
import pages.SearchPage;

public class SearchProduct extends TestBase {


	SearchPage SearchPageObject;
	
   ProductDetailespage productDetailesObject;
   
   
   String productName = "Apple MacBook Pro 13-inch";

@Test

     public void Searchonproductname () {
	
	SearchPageObject = new SearchPage(driver);
	SearchPageObject.productsearch(productName);
	SearchPageObject.OpenProductDetails();
	productDetailesObject = new ProductDetailespage(driver);
	//Assert.assertTrue(productDetailesObject.productNamebreadcrumb.getText().equalsIgnoreCase(productName));
	Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(),productName);
	
	
	
	
}
}