package pages;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContatctUspage extends PageBase{
	

	public ContatctUspage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy (id="FullName")
	WebElement fullNameTxt;
	
	@FindBy (id="Email")
	WebElement EmailTxt;

	@FindBy (id="Enquiry")
	
	WebElement EnquiryTxt;
	
	@FindBy (name = "send-email")
	WebElement submitbutton;
	
	@FindBy (css ="div.result")
	public WebElement successmessage;
	
	
	
	
	public void ContactUs(String fullname , String email , String Enquiry) {
		
		
		setTextElement(fullNameTxt ,fullname);
		setTextElement(EmailTxt , email);
		setTextElement(EnquiryTxt ,Enquiry);
		clickbutton(submitbutton);
	}
	
	
	
}
