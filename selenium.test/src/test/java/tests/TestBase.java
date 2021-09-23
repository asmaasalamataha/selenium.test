package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilitis.Helpertotackescreenshoots;
//import com.paulhammant.ngwebdriver.NgWebDriver;


//using class (AbstracttestNGcucumber)
public class TestBase extends AbstractTestNGCucumberTests {

	 protected WebDriver driver;
	//public static JavascriptExecutor jsDriver;
	//public static NgWebDriver  ngDriver;
	public static String downloadPath = System.getProperty("user.dir") + "\\download";
	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	
	
	
	

	@BeforeSuite
	//ma3nah eno be2lo w ent btro7 tft7 el driver ro7 detect eh el value 
	//elmawgoda fy tsngfile llparamter da w hato
	@Parameters({ "browser" })
	
	// bst5dm optional da 3ashan fy 7alt eno mal2ash ay value llparamter ya run chrome
	
	public void startdriver(@Optional("chrome") String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(chromeOption());
		}
		else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		}
		
		//jsDriver = (JavascriptExecutor) driver;
	//	ngDriver = new NgWebDriver(jsDriver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get("https://demo.nopcommerce.com/");
		driver.navigate().to("http://demo.nopcommerce.com/");
		// ngDriver.waitForAngularRequestsToFinish();
		 
	}

	@AfterSuite
	public void stopdriver() {

		driver.quit();
	}

	
	// take screenschoot if the cases failed 
	
	@AfterMethod
	public void Screenshootonfailuercase (ITestResult result) throws Exception
	{
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			System.out.println("failed");
			System.out.println("taking screenshoot.....");
			Helpertotackescreenshoots.capturescreenshoots(driver ,result.getName());
	}
	
	}
}
