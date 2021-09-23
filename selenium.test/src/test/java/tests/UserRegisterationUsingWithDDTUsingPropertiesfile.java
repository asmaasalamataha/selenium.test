package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationUsingWithDDTUsingPropertiesfile extends TestBase {

	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	String firstname = LoadProperties.userdata.getProperty("firstname");
	String lastname = LoadProperties.userdata.getProperty("lastname" ); 
	String email = LoadProperties.userdata.getProperty("email"); 
	String password = LoadProperties.userdata.getProperty("password"); 
	
	
	
	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() {
		System.out.println("This is the first name : " + firstname);
		
		
		homeobject = new HomePage(driver);
		registrationobject = new UserRegisteration(driver);
		
		
		// take object mn el method elmowgoda fy home page
		homeobject.openregisterpage();
		registrationobject.userregisteration(firstname , lastname, email, password );

		// validate the scenario
		assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = { "usercanregistersuccessfully" })
	public void Registerusercanlogout() {
		
		
		menuPageObject = new MenuPage(driver);
		loginobject = new LoginPage(driver);

		menuPageObject.userlogout();
		//Assert
		assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());

	}

	@Test(dependsOnMethods = { "Registerusercanlogout" })

	public void Registerusercanlogin() {

		homeobject.openloginpage();
		loginobject = new LoginPage(driver);
		loginobject.userlogin(email, password);
		

		//Assert
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		
		
	}
}
