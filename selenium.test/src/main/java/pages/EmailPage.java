package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {
	
	public EmailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (id="FriendEmail")
	WebElement FriendEmailTxt;
	
	@FindBy (id="YourEmailAddress")
	WebElement MyEmailTxt;

	@FindBy (id="PersonalMessage")
	
	WebElement PersonalMessageTxt;
	
	@FindBy (name = "send-email")
	WebElement SendEmailbutton;
	
	@FindBy (css ="div.result")
	public WebElement Confirmmessage;
	
	
	public void SendEmailtofriend (String FriendEmail, String PersonalMessage)
	{
		
		
		setTextElement(FriendEmailTxt, FriendEmail);
		setTextElement(PersonalMessageTxt , PersonalMessage);
		clickbutton(SendEmailbutton);
		
	}
			
			

}
