package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReadear;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationPageUsingWithDDTExcelsheet extends TestBase {
// take object from class homepage&userregisteration 
	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	@DataProvider(name="ExcelData")
	
	public Object [] [] userregisterdata() throws IOException{
		
	// get data from ExcelReader class
		
		ExcelReadear excelreader = new ExcelReadear();
		return excelreader.getExcelData();
	}
	
	
	
	@Test(priority = 1, alwaysRun = true,dataProvider="ExcelData")

	public void usercanregistersuccessfully(String firstname , String lastname ,String email ,String pasword ) {
		
		
		homeobject = new HomePage(driver);
		menuPageObject = new MenuPage(driver);
		loginobject = new LoginPage(driver);
		registrationobject = new UserRegisteration(driver);
		loginobject = new LoginPage(driver);
		
		
		homeobject.openregisterpage();
		registrationobject.userregisteration(firstname ,lastname ,email , pasword);
		assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
		menuPageObject.userlogout();
		assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());
		homeobject.openloginpage();
		loginobject.userlogin(email,pasword );
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		menuPageObject.userlogout();
		
		
	

	}
	

}
