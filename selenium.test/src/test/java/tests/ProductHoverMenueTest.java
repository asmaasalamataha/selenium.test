package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenueTest extends TestBase {

	HomePage homeobject;

	@Test(priority = 1, alwaysRun = true)

	public void usercanHoveronMainMenueandSelectfromSubmenue() {

		homeobject = new HomePage(driver);
		homeobject.HoveronComputerMenue();
		Assert.assertTrue(homeobject.confirmGointoNotebooks.getText().contains("Notebooks"));

	}

}
