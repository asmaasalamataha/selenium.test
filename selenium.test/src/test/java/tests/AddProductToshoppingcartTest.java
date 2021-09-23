package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailespage;
import pages.SearchPage;
import pages.ShoppingCartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AddProductToshoppingcartTest extends TestBase{
	
	
	ShoppingCartPage ShoppingCartObjectPage;
	SearchPage SearchPageObject;
	ProductDetailespage productDetailesObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	
	@Test(priority = 1, alwaysRun = true)
	public void UsercansearchUsingAutosuggest () throws Exception{
		
		//AAA Arrange Act Assert
		
			SearchPageObject = new SearchPage(driver);
			SearchPageObject.searchUsingAutosuggest("MacB");
			productDetailesObject = new ProductDetailespage(driver);
			Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(), productName);
			
			
	}

		
			@Test(dependsOnMethods = { "UsercansearchUsingAutosuggest" })
			
			public void UserCanAddProducttoShoppingCart () throws Exception {
				
				
				//Arrange
				
				productDetailesObject = new ProductDetailespage(driver);
				productDetailesObject.canAddtoCartBtton();
				WebDriverWait wait = new WebDriverWait(driver,30);
				driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.product-unit-price"))); 
				
				//Act
				
				ShoppingCartObjectPage = new ShoppingCartPage(driver);
				ShoppingCartObjectPage.UpdateProductQuantityIncart("4");
				
				// Assert
				
				
				Assert.assertEquals("4",ShoppingCartObjectPage.quantitynumber );
				Assert.assertEquals("Your Shopping Cart is empty!",ShoppingCartObjectPage.confirmationmessage);
				
				
				
			}
			
			
			
	}
		

