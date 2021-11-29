package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class CheckoutOverviewPage extends BasePage {

	public CheckoutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart_item")
	private List<WebElement> cartItems;

	@FindBy(css = ".summary_info > .summary_value_label:nth-child(2)")
	private WebElement paymentInformationLabel;

	@FindBy(css = ".summary_info > .summary_value_label:nth-child(4)")
	private WebElement shippingInformationLabel;

	@FindBy(css = ".summary_subtotal_label")
	private WebElement subTotalLabel;

	@FindBy(css = ".summary_tax_label")
	private WebElement taxLabel;

	@FindBy(css = ".summary_total_label")
	private WebElement totalLabel;

	@FindBy(id = "finish")
	private WebElement finishButton;

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

	public String getPaymentInformation() {
		return paymentInformationLabel.getText();
	}

	public String getShippingInformation() {
		return shippingInformationLabel.getText();
	}

	public double getSubTotal() {
		return Double.valueOf(subTotalLabel.getText().replace("Item total: $", "").trim());
	}

	public double getTax() {
		return Double.valueOf(taxLabel.getText().replace("Tax: $", "").trim());
	}

	public double getTotal() {
		return Double.valueOf(totalLabel.getText().replace("Total: $", "").trim());
	}

	public void finish() {
		finishButton.click();
	}
}