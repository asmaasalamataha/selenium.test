package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(css ="button.button-1.checkout-as-guest-button")
	WebElement checkoutAsguestbutton;
	
	@FindBy(id ="BillingNewAddress_FirstName")
	WebElement firstNameText;
	
	@FindBy(id ="BillingNewAddress_LastName")
	WebElement lastNameText;

	@FindBy(id ="BillingNewAddress_Email")
	WebElement EmailText;
	
	@FindBy(id ="BillingNewAddress_CountryId")
	WebElement Countrylist; 
	
	@FindBy(id ="BillingNewAddress_City")
	WebElement CityText; 
	
	@FindBy(id ="BillingNewAddress_Address1")
	WebElement Address1Text; 
	
	@FindBy(id ="BillingNewAddress_ZipPostalCode")
	WebElement ZipPostalCodeText; 
	
	@FindBy(id ="BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberText; 
			
	@FindBy(css ="button.button-1.new-address-next-step-button")
	WebElement ContinuebuttoninBillingAddress;
	
	
	@FindBy(id ="shippingoption_0")
	WebElement shippingOptionRadiobutton; 		
	
	@FindBy(css ="button.button-1.shipping-method-next-step-button")
	WebElement ContinuebuttoninShippingMethod;
	
	@FindBy(id ="paymentmethod_0")
	WebElement paymentMethodradiobutton;
	
	@FindBy(css ="button.button-1.payment-info-next-step-button")
	WebElement ContinuebuttoninPaymentInfo;
	
	@FindBy(css ="button.button-1.payment-method-next-step-button")
	WebElement ContinuebuttoninPaymentMethod;
	
	@FindBy(css ="button.button-1.confirm-order-next-step-button")
	WebElement confirmbutton;
	
	@FindBy(linkText= "Click here for order details." )
	
	public WebElement successMessage;
	
	
	@FindBy(linkText ="Click here for order details.")
	WebElement orderDetailsLink;
	

	@FindBy(css ="button.button-1.order-completed-continue-button")
	WebElement continuebuttontobacktohomePage;
	
	
    public void checkoutAsguest() 
	
	{
		clickbutton(checkoutAsguestbutton);
		
	}
	
	public void checkoutProductAsguest ( String Firstname , String Lastname , String Email , String countryName 
	, String City , String Address1 , String ZipPostalCode , String PhoneNumber ) throws InterruptedException {
	

	setTextElement( firstNameText , Firstname );
	setTextElement( lastNameText  , Lastname);
	setTextElement( EmailText     , Email );
	select = new Select (Countrylist);
	select.selectByVisibleText( countryName );
	setTextElement( Countrylist   , countryName);
	setTextElement( CityText      , City );
	setTextElement( Address1Text  , Address1  );
	setTextElement( ZipPostalCodeText , ZipPostalCode);
	setTextElement( PhoneNumberText , PhoneNumber  );
	Thread.sleep(1000);
	clickbutton(ContinuebuttoninBillingAddress);
	Thread.sleep(1000);
	clickbutton(shippingOptionRadiobutton);
	clickbutton(ContinuebuttoninShippingMethod);
	clickbutton(paymentMethodradiobutton);
	clickbutton(ContinuebuttoninPaymentMethod);
	clickbutton(ContinuebuttoninPaymentInfo);
	
	
	
	}
	
	public void confirmOrder() 
	
	{
		clickbutton(confirmbutton);
		//clickbutton(continuebuttontobacktohomePage);
	}
	
   public void viewOrderDetails ()
	
	{
		clickbutton(orderDetailsLink);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
