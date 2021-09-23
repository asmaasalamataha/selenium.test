package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContatctUspage;
import pages.HomePage;

public class ContactUsTestpage extends TestBase {

	HomePage homeobject;
	ContatctUspage ContactUspageObject;
	String fullname = "asmaa salama";
	String email = "asmaa.salama@test.com";
	String Enquiry = "iam searching for new tab";

	@Test(priority = 1, alwaysRun = true)

	public void UserCanUsecontactUs() {

		// take object mn el method elmowgoda fy home page
		homeobject = new HomePage(driver);
		homeobject.OpencontactUsPage();
		ContactUspageObject = new ContatctUspage(driver);
		ContactUspageObject.ContactUs(fullname, email, Enquiry);
		Assert.assertTrue(ContactUspageObject.successmessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner"));
	}

}
