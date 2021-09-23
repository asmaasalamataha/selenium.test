package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddWishListPage extends PageBase {

	public AddWishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(css="td.sku")
	public WebElement ProductSKUCell;
	
	@FindBy(css=" h1")
	public WebElement Wishlistheader;
	
	@FindBy(name="updatecart")
	public WebElement updateWishlistbutton;
	
	@FindBy(css="p.content")
	public WebElement AddWishListBtton;
	
	@FindBy(css = "button.button-2.wishlist-add-to-cart-button")
	public WebElement AddtocartButton;
	
	@FindBy(name="addtocart")
	public WebElement Addtocartcheckbox;
	
	@FindBy(css= "td.remove-from-cart")
	public WebElement RemoveProductSign;
	//no-data
	//page-body
	@FindBy(css = "div.page-body")
	public WebElement TxtTovalidateRemovefromWishlist;
	
	@FindBy(linkText = "wishlist")
	public WebElement Wishlistlink;
	
	public void RemoveProductFromWishlist() {
		
      clickbutton(RemoveProductSign);
     
     
		
		
	}
	
	
}


