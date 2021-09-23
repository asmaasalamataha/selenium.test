package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.ProductDetailespage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.orderDetailsPage;

public class RegisterUserCheckOutProduct extends TestBase{
	
	
	SearchPage SearchPageObject;
	ShoppingCartPage ShoppingCartObjectPage;
	ProductDetailespage productDetailesObject;
    CheckOutPage CheckOutPageObject;
    orderDetailsPage  orderObject   ;
	String productName = "Apple MacBook Pro 13-inch";
	 String Firstname = "Asmaa";
	 String Lastname ="salama";
	 String Email = "a@hotmail.com";
	 String countryName ="Egypt";
	 String City = "cairo";
	 String Address1 = "cairo";
	 String ZipPostalCode = "02";
	 String PhoneNumber = "1111394436";


	@Test(priority = 1, alwaysRun = true)

	public void UsercansearchUsingAutosuggest() {
		
		// Arrange
		SearchPageObject = new SearchPage(driver);
		productDetailesObject = new ProductDetailespage(driver);
		
		// Act
		SearchPageObject.searchUsingAutosuggest("MacB");
		
		// Assert
		Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(), productName);

	}
	
	@Test(dependsOnMethods = { "UsercansearchUsingAutosuggest" })
	
	public void UserCanAddProducttoShoppingCart () throws Exception {
		
		
		//Arrange
		productDetailesObject = new ProductDetailespage(driver);
		ShoppingCartObjectPage = new ShoppingCartPage(driver);
		//Act
		productDetailesObject.canAddtoCartBtton();
	
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		ShoppingCartObjectPage.productscolum = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple MacBook Pro 13-inch")));

		// Assert
	
		assertTrue(ShoppingCartObjectPage.tolabel.getText().contains("3,600"));
		//assertEquals(ShoppingCartObjectPage.tolabel.getText() ,"$3,600.00" ) ;
			
	}
	
	@Test(dependsOnMethods = { "UserCanAddProducttoShoppingCart" })
	
	public void UserCancheckoutproductAsguset () throws Exception{
		
		//Arrange
		CheckOutPageObject = new CheckOutPage(driver);
		ShoppingCartObjectPage = new ShoppingCartPage(driver);
		
		//Act
		ShoppingCartObjectPage.OpenCheckOutPage();
		CheckOutPageObject.checkoutAsguest() ;
		CheckOutPageObject.checkoutProductAsguest(Firstname,  Lastname , Email , countryName ,
		City , Address1 , ZipPostalCode , PhoneNumber ) ;
		CheckOutPageObject.confirmOrder();
		
		//Assert
		
		assertEquals(CheckOutPageObject.successMessage.getText(),"Click here for order details.");
		
		
		 
	}
	
	@Test(dependsOnMethods = { "UserCancheckoutproductAsguset" })
	public void UserCanViewOrderDetails() throws Exception {
		
		//Arrange 
		CheckOutPageObject = new CheckOutPage(driver);
		orderObject = new orderDetailsPage(driver);
		
		//Act
		CheckOutPageObject.viewOrderDetails();
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
		
		//Assert
		assertTrue(driver.getCurrentUrl().contains("orderdetails"));
	}

}
	


