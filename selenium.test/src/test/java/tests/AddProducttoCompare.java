package tests;

import static org.testng.Assert.assertEquals;

import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import pages.ComparePage;
import pages.ProductDetailespage;
import pages.SearchPage;

public class AddProducttoCompare extends TestBase {

	String FirstProductName = "Apple MacBook Pro 13-inch";
	String SecondProductName = "Asus N551JK-XO076H Laptop";

	// 1.search for product 1
	// 2. search for product 2
	// 3.Add to compare
	// Clear list

	SearchPage SearchPageObject;
	ProductDetailespage productDetailesObject;
	ComparePage comparePageObject;

	@Test(priority = 1, alwaysRun = true)
	public void UsercansearchUsingAutosuggest() throws Exception {

		// Arrange
		SearchPageObject = new SearchPage(driver);
		productDetailesObject = new ProductDetailespage(driver);
		comparePageObject = new ComparePage(driver);
		// ACT
		SearchPageObject.searchUsingAutosuggest("MacB");
		productDetailesObject.addCompareProducts();
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		// Assert
		assertEquals(comparePageObject.ToconfirmProduct1AddtoComparePage.getText(), "Apple MacBook Pro 13-inch");
	}

	@Test(dependsOnMethods = { "UsercansearchUsingAutosuggest" })
	public void UsercansearchUsingAutosuggestForSecondProduct() throws Exception {

		// Arrange
		SearchPageObject = new SearchPage(driver);
		productDetailesObject = new ProductDetailespage(driver);

		// ACT
		SearchPageObject.searchUsingAutosuggest("Asus");
		productDetailesObject.addCompareProducts();
		comparePageObject = new ComparePage(driver);

		// Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		comparePageObject.ToconfirmProduct2AddtoComparePage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Asus N551JK-XO076H Laptop")));

		// Assert
		// Assert.assertEquals(productDetailesObject.productNamebreadcrumb.getText(),
		// SecondProductName);
		Assert.assertEquals("Asus N551JK-XO076H Laptop", comparePageObject.ToconfirmProduct2AddtoComparePage.getText());
	}

	@Test(dependsOnMethods = { "UsercansearchUsingAutosuggestForSecondProduct" })
	public void UsercanComparebetweenProducts() throws Exception {

		
		
		// Arrange
		comparePageObject = new ComparePage(driver);

		// Act
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");

		// Assert

		assertThat(comparePageObject.getCompareProductHeader(), hasItem("Name"));

		// Assert.assertEquals(ComparePageObject.Compareproducts(),"8 Remove Remove Name
		// Asus N551JK-XO076H Laptop Apple MacBook Pro 13-inchPrice $1,500.00
		// $1,800.00Screensize 15.6'' 13.0''CPU Type Intel Core i7 Intel Core i5Memory
		// 16 GB 4 GBHard drive 1 TB RemoveRemove NameAsus N551JK-XO076H LaptopApple
		// MacBook Pro 13-inchPrice$1,500.00$1,800.00Screensize15.6''13.0''CPU TypeIntel
		// Core i7Intel Core i5Memory16 GB4 GBHard drive1 TB ");

	}

	@Test(priority = 3, alwaysRun = true)

	public void UsercanClearCompareList() {

		comparePageObject.clearcompairlist();

		Assert.assertEquals("You have no items to compare.", comparePageObject.nodatalabel.getText());

	}
}
