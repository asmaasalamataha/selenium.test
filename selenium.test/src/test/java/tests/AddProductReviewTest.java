package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductDetailespage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisteration;

public class AddProductReviewTest extends TestBase {

	SearchPage SearchPageObject;
	ProductDetailespage productDetailesObject;
	String productName = "Apple MacBook Pro 13-inch";
	HomePage homeobject;
	UserRegisteration registrationobject;
	EmailPage EmailPageobject;
	MenuPage menuPageObject;
	ProductReviewPage ProductReviewPageObject;

	String firstname = "Asmaa";
	String lastname = "ahmed";
	String email = "asmaa.7@test.com";
	String password = "asmaataha";
	String ReviewTitle = "good experience";
	String Review = "the quality is very good ";

	@Test(priority = 1, alwaysRun = true)

	public void usercanregistersuccessfully() {

		// take object mn el method elmowgoda fy home page
		homeobject = new HomePage(driver);
		homeobject.openregisterpage();
		// take object mn el method elmowgoda fy home page
		registrationobject = new UserRegisteration(driver);
		registrationobject.userregisteration(firstname, lastname, email, password);

		// validate the scenario
		Assert.assertTrue(registrationobject.successmessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2, alwaysRun = true)
	public void UsercansearchUsingAutosuggest() {

		try {
			SearchPageObject = new SearchPage(driver);
			SearchPageObject.searchUsingAutosuggest("MacB");
			productDetailesObject = new ProductDetailespage(driver);
			Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(), productName);

		} catch (Exception e) {

			System.out.println("Error occured " + e.getMessage());
		}
	}

	@Test(priority = 3, alwaysRun = true)

	public void UsercanAddProductReview() {

		productDetailesObject = new ProductDetailespage(driver);
		productDetailesObject.CanAddProductReview();
		ProductReviewPageObject = new ProductReviewPage(driver);
		ProductReviewPageObject.youCanAddProductReview(ReviewTitle, Review);
		Assert.assertTrue(ProductReviewPageObject.validationtxt.getText().contains("From: Asmaa"));
	}
	
	

}
