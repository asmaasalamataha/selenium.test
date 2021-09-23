package tests;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationPageUsingWithDDTJavafaker extends TestBase {
// take object from class homepage&userregisteration 
	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	Faker fakerdata = new Faker();
	
	String firstname = fakerdata.name().firstName();
	String lastname = fakerdata.name().lastName();
	String email = fakerdata.internet().emailAddress();
	String password = fakerdata.number().digits(6).toString();
	
	 
	
	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() {
		
		// take object mn el method elmowgoda fy home page
		homeobject = new HomePage(driver);
		registrationobject = new UserRegisteration(driver);
		
		
		// take object mn el method elmowgoda fy home page
		homeobject.openregisterpage();
		registrationobject.userregisteration(firstname,lastname,email,password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
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
