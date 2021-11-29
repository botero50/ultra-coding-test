package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".inventory_item")
	private List<WebElement> inventoryItems;

	private By itemName = By.cssSelector(".inventory_item_name");
	private By itemPrice = By.cssSelector(".inventory_item_price");
	private By itemAddButton = By.cssSelector(".btn_inventory");

	/***
	 * This method adds a product to the cart and returns the price of it
	 * 
	 * @param productName
	 * @return value of the product added
	 */
	public String addProduct(String productName) {
		for (WebElement element : inventoryItems) {
			if (element.findElement(itemName).getText().trim().equalsIgnoreCase(productName)) {
				element.findElement(itemAddButton).click();
				return element.findElement(itemPrice).getText();
			}
		}
		return "";
	}
}