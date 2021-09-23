package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;

public class UserRegisterationPageWithUsingDDTCVSfile extends TestBase {

	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	// take object from CSvReader w da ely hae2ra el data mn el CSV file 
	CSVReader reader;
	
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully() throws  IOException, CsvValidationException  {
	
	// get path for CSV file 
	
String CSV_file = "D:\\seleniumcourse\\eclipse\\selenium.test\\src\\test\\java\\data\\UserData.csv";
	// lazm a2lo el reader hae2ra mnen
	reader = new CSVReader(new FileReader(CSV_file));
	String [] csvCell;
	//while loop will be excuted till the lastvalue in csv file 
	while((csvCell = reader.readNext()) != null)  {
		
		String firstname = csvCell[0];
		String lastname = csvCell[1];
		String email = csvCell[2];
		String password	= csvCell[3];
		
		
		homeobject = new HomePage(driver);
		menuPageObject = new MenuPage(driver);
		loginobject = new LoginPage(driver);
		registrationobject = new UserRegisteration(driver);
		loginobject = new LoginPage(driver);
		
		
		homeobject.openregisterpage();
		registrationobject.userregisteration(firstname ,lastname ,email , password);
		assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
		menuPageObject.userlogout();
		assertTrue(loginobject.loginbttonatmenuepage.isDisplayed());
		homeobject.openloginpage();
		loginobject.userlogin(email,password);
		assertTrue(menuPageObject.logoutbutton.isDisplayed());
		menuPageObject.userlogout();
	}
}}
	
	