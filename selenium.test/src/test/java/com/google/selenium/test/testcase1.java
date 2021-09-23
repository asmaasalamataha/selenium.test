package com.google.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  // Take new Object from Chrome Driver
   WebDriver driver = new ChromeDriver();
	      // open Google URL from WebDriver
	driver.get("http://www.google.com");
	driver.navigate().to("http://www.amzon.com");
		// Close Driver
		driver.quit();
	}
	

}
