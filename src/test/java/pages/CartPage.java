package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart_item")
	private List<WebElement> cartItems;

	@FindBy(name = "checkout")
	private WebElement checkoutButton;

	private By itemName = By.cssSelector(".inventory_item_name");
	private By itemPrice = By.cssSelector(".inventory_item_price");

	/***
	 * Method created to get the price of an item by an specific name
	 * 
	 * @param productName
	 * @return value of the product with an specific name
	 */
	public String getItemPriceByItemName(String productName) {
		for (WebElement element : cartItems) {
			if (element.findElement(itemName).getText().trim().equalsIgnoreCase(productName)) {
				return element.findElement(itemPrice).getText();
			}
		}
		return "";
	}

	public void checkout() {
		checkoutButton.click();
	}
}