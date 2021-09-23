package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

import pages.MenuPage;
import pages.MyaccountPage;
import pages.UserRegisteration;

public class MyaccountTest extends TestBase {
	HomePage homeobject;
	UserRegisteration registrationobject;
	
	MenuPage menuPageObject;
	MyaccountPage myaccountpageObject;
	// string firstname = asmaa;
	// string lastname = ahmed;
	// string email    = asmaa.3@test.com;
	// string password = asmaataha;
	// old password    = asmaataha;
	// new password    = asmaasalama;
	
	
	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() {
		
		// take object mn el method elmowgoda fy home page
		homeobject = new HomePage(driver);
		homeobject.openregisterpage();
		// take object mn el method elmowgoda fy home page
		registrationobject = new UserRegisteration(driver);
		registrationobject.userregisteration("Asmaa", "Salama" , "asmaa_salama2022@test.com" , "asmaataha" );

		// validate the scenario
		Assert.assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = { "usercanregistersuccessfully" })
	public void Registerusercanchangepassword () {
		
		menuPageObject = new MenuPage(driver);
		menuPageObject.OpenMyaccountPage();
		myaccountpageObject = new MyaccountPage (driver);
		myaccountpageObject.OpenChangePasswordlinktext();
		myaccountpageObject.ChangePassword("asmaataha", "tahamostafa");
		// validate the scenario
				Assert.assertTrue(myaccountpageObject.textlabel.getText().contains("Password was changed"));
		
	}


}
