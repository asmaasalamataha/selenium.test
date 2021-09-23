package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetailespage extends PageBase{

	public ProductDetailespage(WebDriver driver) {
		super(driver);
		
	}

	
	//@FindBy(css="strong.current-item")
	@FindBy(css=" h1")
	public WebElement productNamebreadcrumb;
	
	@FindBy(css="div.email-a-friend")
	public WebElement EmailaFriendButton;
	
	@FindBy(css="span.price-value-4")
	public WebElement productpricelabel;
	
	@FindBy(linkText="Add your review")
	public WebElement AddReviewBtton;
	
	@FindBy(id="add-to-wishlist-button-4")
	public WebElement AddtoWishListBtton;
	
	@FindBy(css ="button.button-2.add-to-compare-list-button")
	public WebElement AddtocompareBtton;
	
	@FindBy(id="add-to-cart-button-4")
	
	public WebElement AddtoCartBtton;
	
    public void canAddtoCartBtton () {
		
		
		clickbutton(AddtoCartBtton);
	}
	
	public void cansendEmailtoFriend () {
		
		
		clickbutton(EmailaFriendButton);
	}
	
	public void CanAddProductReview () {
		
		
		clickbutton(AddReviewBtton);
	}
	
    public void CanAddProducttoWishList () {
		
		
		clickbutton(AddtoWishListBtton);
    }
   public void addCompareProducts () {
		
		
		clickbutton(AddtocompareBtton);
    }
    
    
    
    
}
