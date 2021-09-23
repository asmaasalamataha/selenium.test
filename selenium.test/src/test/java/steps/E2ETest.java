package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.ProductDetailespage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisteration;
import pages.orderDetailsPage;
import tests.TestBase;

public class E2ETest extends TestBase {
	
	SearchPage SearchPageObject;

	ProductDetailespage productDetailesObject;
	ShoppingCartPage ShoppingCartObjectPage;
    CheckOutPage CheckOutPageObject;
    orderDetailsPage  orderObject   ;
    
    
    @Given("user on the home page")
	public void user_on_the_home_page() throws Throwable  {
	assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}
	
	@When("^he search for \"([^\"]*)\"$")  
	public void he_search_for(String productName)throws Throwable {
		
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.searchUsingAutosuggest(productName);
		productDetailesObject = new ProductDetailespage(driver);
		assertEquals(productDetailesObject.productNamebreadcrumb.getText(), "Apple MacBook Pro 13-inch");
	}
	

	@When("^Add the products in the shooping cart$") 
	public void add_the_products_in_the_shooping_cart() throws InterruptedException {
	
		productDetailesObject = new ProductDetailespage(driver);
		productDetailesObject.canAddtoCartBtton();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com/" + "cart");
		
	}
	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		
		CheckOutPageObject = new CheckOutPage(driver);
		ShoppingCartObjectPage = new ShoppingCartPage(driver);
		ShoppingCartObjectPage.OpenCheckOutPage();
		CheckOutPageObject.checkoutAsguest() ;
		CheckOutPageObject.checkoutProductAsguest("test", "user","testuse@test.com", "Egypt"
				, "Cairo","cairo", "02","1111394436") ;
		CheckOutPageObject.confirmOrder();
		assertEquals(CheckOutPageObject.successMessage.getText(),"Click here for order details.");
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		
		
		
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

	

