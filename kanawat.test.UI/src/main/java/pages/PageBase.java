package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	protected static void clickbutton (WebElement button) {	
		button.click();
	}
	
	protected static void setTextElement (WebElement textElement , String value) {
		//textElement.sendKeys(String.valueOf(value));
		textElement.sendKeys(value);
	}
	
	//protected static void setTextElementfornumber (WebElement textElement , int value ) {
		// textElement.sendKeys("value");
	//}
	
	public void ScrollToBotton () {
		
		jse.executeScript("window.scrollBy(0,1000)");
		
		
	}
	
	public void ClearText (WebElement element) {
		
		element.clear();	
		
		
	}
	
	
}

	


