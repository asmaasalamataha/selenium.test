package steps;




import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserRegisteration;
import tests.TestBase;

public class UserRegisterationwithCucumber extends TestBase {

	HomePage homeobject;
	UserRegisteration registrationobject;
	LoginPage loginobject;
	MenuPage menuPageObject;
	
	

	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
		homeobject = new HomePage(driver); 
		homeobject.openregisterpage();
	}

	@When("^I click on register link$")
	public void i_click_on_register_link()  {
		assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*@When("^I entered the user data$")
	public void i_entered_the_user_data()  {
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "moataz@test.com", "12345678");
	}*/

	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registrationobject = new UserRegisteration(driver); 
		registrationobject.userregisteration(firstname, lastname,email,password);
	}

	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully()  {
		menuPageObject = new MenuPage(driver);
		menuPageObject.userlogout();
	}
}
