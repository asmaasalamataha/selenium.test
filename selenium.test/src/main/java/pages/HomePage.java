package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	
	
	

	@FindBy(linkText = "Register")
	WebElement registerlink;
	
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	

	@FindBy (linkText ="Contact us")
	public WebElement ContactUsbutton;
	
	
	@FindBy (linkText ="Computers")
	public WebElement computersMenue;
	
	
	@FindBy (linkText ="Notebooks")
	public WebElement NotebooksMenue;
	
	@FindBy (name ="Notebooks")
	public WebElement confirmGointoNotebooks;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// initialize el java script fy el constractor
		 jse = (JavascriptExecutor) driver;
		 action = new Actions (driver);
		
	}

	public void openregisterpage() {
		clickbutton(registerlink);
	}
	
	public void openloginpage() {		
		clickbutton(loginlink);
	}
	
	public void OpencontactUsPage () {
		
		ScrollToBotton ();
		clickbutton(ContactUsbutton);
		
		
	}
	
   public void HoveronComputerMenue () {
		
	   action.moveToElement(computersMenue).moveToElement(NotebooksMenue).click().build().perform();
   }
}
	
