package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
		@FindBy(id = "Email")
		WebElement emailtextbox;

		@FindBy(id = "Password")
		WebElement passtextbox ;
		
		
		@FindBy(linkText ="Log in")
		public WebElement loginbttonatmenuepage ;
		
		@FindBy(css ="button.button-1.login-button")
		public WebElement loginbttonathomepage ;
		
		
		public void userlogin (String email , String Password ) {
			
			
			setTextElement(emailtextbox , email);
			setTextElement(passtextbox , Password);
			clickbutton(loginbttonathomepage)	;
		}
		
		
		

}
