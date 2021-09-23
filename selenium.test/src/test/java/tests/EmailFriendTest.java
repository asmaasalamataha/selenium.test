package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductDetailespage;
import pages.SearchPage;
import pages.UserRegisteration;

public class EmailFriendTest extends TestBase {
	
	 SearchPage SearchPageObject;
     ProductDetailespage productDetailesObject;
     String productName = "Apple MacBook Pro 13-inch";
	 HomePage homeobject;
	 UserRegisteration registrationobject;
	 EmailPage EmailPageobject;
	 MenuPage menuPageObject;
	 LoginPage loginobject;
	 String firstname = "asmaa";
	 String lastname = "ahmed";
	 String email    = "asmaa.6@test.com";
	 String password = "asmaataha";
	 String FriendEmail = "ahmed.salama@hotmail.com";
	 String PersonalMessage ="hello my friend";
		
	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() {
		
		// take object mn el method elmowgoda fy home page
		homeobject = new HomePage(driver);
		homeobject.openregisterpage();
		// take object mn el method elmowgoda fy home page
		registrationobject = new UserRegisteration(driver);
		registrationobject.userregisteration( firstname, lastname, email, password);

		// validate the scenario
		Assert.assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2, alwaysRun = true)
	  public void UsercansearchUsingAutosuggest () {
			
	    	 try {
	    		 SearchPageObject = new SearchPage(driver);
	    			SearchPageObject.searchUsingAutosuggest("MacB");
	    			productDetailesObject = new ProductDetailespage(driver);
	    			Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(),productName);
	    			
	    	 }
	    	 catch (Exception e)
	    	 {
	    		 
	    		 System.out.println("Error occured " +e.getMessage());
	    	 }
	}
	
	//EmailFriendTest
	    	 
	    	 @Test 
	    	 public void UsercanSendEmailtofriend () {
	    		 
	    		 productDetailesObject = new ProductDetailespage(driver);
	    		 productDetailesObject.cansendEmailtoFriend();
	    		 EmailPageobject = new EmailPage(driver);
	    		
	    		 EmailPageobject.SendEmailtofriend(PersonalMessage ,PersonalMessage);
	    		 Assert.assertTrue(EmailPageobject.Confirmmessage.getText().contains("Your message has been sent"));
	    		 
	    		
	    	 }
	    	 
	    	 
	    	 @Test(dependsOnMethods = { "usercanregistersuccessfully" })
	    	 public void Registerusercanlogout() {
	    			menuPageObject = new MenuPage(driver);
	    			menuPageObject.userlogout();
	    			
	    			

	    		}
	    		 
	    		 
	    		 
	    	 
	
	
	

}
