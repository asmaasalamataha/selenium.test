package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductReviewPage extends PageBase{
	
	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
		
		}
	@FindBy(id="addproductrating_4")
	public WebElement RatingRadiobutton;
	
	@FindBy(id="AddProductReview_Title")
	public WebElement ReviewTitleTXT;
	
	@FindBy(id="AddProductReview_ReviewText")
	public WebElement Reviewtext;
	
	
	@FindBy(name="add-review")
	public WebElement SubmitReviewButton;
	
	
	@FindBy(css="span.user")
	public WebElement validationtxt;
	
	
	public void youCanAddProductReview (String ReviewTitle , String Review ) {
		
		setTextElement(ReviewTitleTXT , ReviewTitle);
		setTextElement(Reviewtext, Review);
		clickbutton(RatingRadiobutton);
		clickbutton(SubmitReviewButton);
		
	}
	
	
	

}
