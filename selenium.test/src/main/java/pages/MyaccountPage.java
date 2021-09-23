package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends PageBase {

	public MyaccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "OldPassword")
	WebElement OldPasswordTextbox;

	@FindBy(id = "NewPassword")
	WebElement NewPasswordTextbox;

	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTextbox;

	@FindBy(css = "input.button-1.change-password-button")
	WebElement ChangePasswordbutton;

	@FindBy(linkText = "change password")
	public WebElement ChangePasswordlinktext;

	
	@FindBy(css = "div.result")
	public WebElement textlabel;
	
	
	public void OpenChangePasswordlinktext() {

		clickbutton(ChangePasswordlinktext);

	}

	public void ChangePassword(String oldpassword, String newpassword) {

		setTextElement(OldPasswordTextbox, oldpassword);
		setTextElement(NewPasswordTextbox, newpassword);
		setTextElement(ConfirmNewPasswordTextbox, newpassword);
		clickbutton(ChangePasswordbutton);

	}

}
