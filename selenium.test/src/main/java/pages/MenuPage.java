package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MenuPage extends PageBase{

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Log out")
	public WebElement logoutbutton;
	
	@FindBy(linkText = "My account")
	WebElement Myaccountbutton;
	
	@FindBy(id = "customerCurrency")
	WebElement Currencydropdownlist;
	
	public void userlogout() {

		clickbutton(logoutbutton);

	}
	
	public void OpenMyaccountPage() {

		clickbutton(Myaccountbutton);

}
	
	public void changeCurrency() {
// using select to can choose from dropdownlist
		// new select bata5od webelement 
		select = new Select(Currencydropdownlist);
		select.selectByVisibleText("Euro");
		
}
	
}