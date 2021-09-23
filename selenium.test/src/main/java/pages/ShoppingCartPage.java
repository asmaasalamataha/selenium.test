package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {
	

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(name="updatecart")
	public WebElement UpdateShoppingCart;
	
	@FindBy(css= "td.remove-from-cart")
	public WebElement RemoveProductSign;
	
	@FindBy(css = "td.quantity")
	public WebElement quantitynumber;
	
	//@FindBy(css= "span.product-subtotal")
	//public WebElement tolabel;
	
	@FindBy(css = "td.subtotal")
	public WebElement tolabel;
	@FindBy(css ="span.product-unit-price")
	public WebElement validateProductnamefoundinthepage ;
	
	@FindBy(linkText = "td.subtotal")
	public WebElement productscolum;
	
	@FindBy(css= "div.no-data")
	public WebElement confirmationmessage;
	
	@FindBy(id= "checkout")
	public WebElement checkoutbtton;
	
	
	@FindBy(id= "termsofservice")
	public WebElement Termscheckbox;
	
	
	 public void  OpenCheckOutPage () {
			
			clickbutton(Termscheckbox);	
			clickbutton(checkoutbtton);
			
	 }

		public void UpdateProductQuantityIncart (String Quantity) throws InterruptedException {
			
			//clear quantity
			ClearText(quantitynumber);
			setTextElement(quantitynumber , Quantity);
			clickbutton(RemoveProductSign);
			
		
		}
		 public void RemoveProductFromCart () {
				
				
				clickbutton(RemoveProductSign);
				clickbutton(UpdateShoppingCart);
				
		 }
		
}
		
		