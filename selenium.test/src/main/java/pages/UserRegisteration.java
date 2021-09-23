package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisteration extends PageBase {

	public UserRegisteration(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-female")
	WebElement genderRadiobutton;

	@FindBy(id = "FirstName")
	WebElement fntextbox;

	@FindBy(id = "LastName")
	WebElement lntextbox;

	@FindBy(id = "Email")
	WebElement emailtextbox;

	@FindBy(id = "Password")
	WebElement passtextbox;

	@FindBy(id = "ConfirmPassword")
	WebElement conpasstextbox;

	@FindBy(id = "register-button")
	WebElement registerbutton;

	@FindBy(css = "div.result")
	public WebElement successmessage;

	///@FindBy(linkText = "Log out")
	//WebElement logoutbutton;

	/// @FindBy(id="register-button")
	/// WebElement successmessage;

	public void userregisteration(String firstname, String lastname, String email, String password) {

		clickbutton(genderRadiobutton);
		setTextElement(fntextbox, firstname);
		setTextElement(lntextbox, lastname);
		setTextElement(emailtextbox, email);
		setTextElement(passtextbox, password);
		setTextElement(conpasstextbox, password);
		clickbutton(registerbutton);

	}
	
	//LandingPageBase
	//TODO
	//public void userlogout() {

	//	clickbutton(logoutbutton);

	

}
