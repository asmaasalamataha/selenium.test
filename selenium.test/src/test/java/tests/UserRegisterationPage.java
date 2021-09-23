package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationPage extends TestBase {
// take object from class homepage&userregisteration 
	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() {
		
		// take object mn el method elmowgoda fy home page
		homeobject = new HomePage(driver);
		registrationobject = new UserRegisteration(driver);
		
		
		// take object mn el method elmowgoda fy home page
		homeobject.openregisterpage();
		registrationobject.userregisteration("Asmaa", "salama", "asmaa_salama11@hotmail.com", "tahamostafa");

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
		loginobject.userlogin("asmaa_salama11@hotmail.com", "tahamostafa");
		

		//Assert
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		
		
	}
}
