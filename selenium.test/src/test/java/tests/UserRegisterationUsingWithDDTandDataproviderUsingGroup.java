package tests;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationUsingWithDDTandDataproviderUsingGroup extends TestBase {
// take object from class homepage&userregisteration 
	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;

	
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	
	{
		
		return new Object[][] {
			{"asmaa" , "salama","tesy@gmail.com","12345690"},
			{"asmaa" , "salama","test19@gmail.com","12345690"}
		};
	}
	
	@Test//(dataProvider="testData")

	 
	public void usercanregistersuccessfully() {
//		
//		System.out.println(obj1[0][1]);
//		homeobject = new HomePage(driver);
//		registrationobject = new UserRegisteration(driver);
//		homeobject.openregisterpage();
//		registrationobject.userregisteration(firstname ,lastname ,email , password);
//		assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
	}

	

	@Test(dataProvider="testData")

	public void Registerusercanlogout(Object[][] obj2) {
		
		
		menuPageObject = new MenuPage(driver);
		loginobject = new LoginPage(driver);

		menuPageObject.userlogout();
		//Assert
		assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());

	}

	

	@Test(dataProvider="testData")
	public void Registerusercanlogin(String firstname,String lastname,String email,String  password,Object[][] obj3) {

		homeobject.openloginpage();
		loginobject = new LoginPage(driver);
		loginobject.userlogin( email , password );
		

		//Assert
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		
	}	
	
	}

