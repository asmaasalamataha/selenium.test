package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationPageUsingWithDDTJsonfile extends TestBase {
// take object from class homepage&userregisteration 
	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() throws IOException, ParseException {
		
		
	// take object from jsonreader class to can read the data 
		
		JsonDataReader  jsonreader = new JsonDataReader();
		
		jsonreader.jsonreader();
		
		
		homeobject = new HomePage(driver);
		menuPageObject = new MenuPage(driver);
		loginobject = new LoginPage(driver);
		registrationobject = new UserRegisteration(driver);
		loginobject = new LoginPage(driver);
		
		
		homeobject.openregisterpage();
		registrationobject.userregisteration( jsonreader.firstname,jsonreader.lastname ,jsonreader.email , jsonreader.password);
		assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
		menuPageObject.userlogout();
		assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());
		homeobject.openloginpage();
		loginobject.userlogin(jsonreader.email,jsonreader.password );
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		menuPageObject.userlogout();
		
	}
		
		
	}

	
	