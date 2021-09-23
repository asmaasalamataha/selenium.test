package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a.clear-list")
	public WebElement ClearListLink;

	@FindBy(css = "div.no-data")
	public WebElement nodatalabel;

	@FindBy(css = "table.compare-products-table")
	public WebElement comparetable;

	@FindBy(tagName = "tr")
	public List<WebElement> AllRows;

	@FindBy(tagName = "td")
	public List<WebElement> AllCoulme;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement ToconfirmProduct2AddtoComparePage;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement ToconfirmProduct1AddtoComparePage;

	public void clearcompairlist() {

		clickbutton(ClearListLink);

	}
	
	public List<String> getCompareProductHeader() {
		List<String> columns = new ArrayList<>();
		
		for (WebElement Col : AllCoulme) {
			columns.add(Col.getText());
		}
		
		return columns;
	}

	public String Compareproducts() {

		StringBuilder stringBuilder = new StringBuilder();
		// get all rows
		stringBuilder.append(AllRows.size());

		// get data from all rows
		for (WebElement Row : AllRows) {

			stringBuilder.append(Row.getText());
		}

		for (WebElement Col : AllCoulme) {
			stringBuilder.append(Col.getText());

		}
		
		return stringBuilder.toString();
		

	}
}
