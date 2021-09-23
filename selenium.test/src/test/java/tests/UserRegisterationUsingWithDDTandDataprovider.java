package tests;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationUsingWithDDTandDataprovider extends TestBase {
// take object from class homepage&userregisteration 
	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	//SoftAssert softassert;
	
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"asmaa" , "salama","test05401@gmail.com","12345690"},
			{"asmaa" , "salama","test07901@gmail.com","12345690"}
		};
	}


	@Test(priority = 1, dataProvider="testData")

	public void usercanregistersuccessfully(String firstname, String lastname, String email, String password) {
		
		menuPageObject = new MenuPage(driver);
		loginobject = new LoginPage(driver);
		homeobject = new HomePage(driver);
		registrationobject = new UserRegisteration(driver);
		homeobject.openregisterpage();
		//System.out.println("Step1 finished");
		registrationobject.userregisteration(firstname ,lastname ,email , password);
		menuPageObject.userlogout();
	 //	assertTrue(false);
	//	softassert = new SoftAssert();
   //softassert.assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
		assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());
		//System.out.println("Step2 finished");
		//assertTrue(true);
	//softassert.assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());

	}

	@Test(dependsOnMethods = { "usercanregistersuccessfully" }, dataProvider="testData", alwaysRun = true)
	
	public void Registerusercanlogin(String firstname, String lastname, String email, String password ) {

	//	softassert = new SoftAssert();
		homeobject.openloginpage();
		loginobject = new LoginPage(driver);
		loginobject.userlogin( email , password );
		//System.out.println("Step3 Finished");
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		menuPageObject.userlogout();
		//Assert
		//assertTrue(false);
		
	}
}
