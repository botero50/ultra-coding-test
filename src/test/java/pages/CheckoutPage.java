package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement firstNameInput;

	@FindBy(id = "last-name")
	private WebElement lastNameInput;

	@FindBy(id = "postal-code")
	private WebElement postalCodeInput;

	@FindBy(id = "continue")
	private WebElement continueButton;

	public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();
	}
}