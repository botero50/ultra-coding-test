package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class topMenuPage extends BasePage {

	public topMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".shopping_cart_link")
	private WebElement cartButton;

	public void goToCart() {
		cartButton.click();
	}
}