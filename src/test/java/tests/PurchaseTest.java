package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import common.BasePage;
import common.checkoutData;
import common.purchaseData;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.topMenuPage;

public class PurchaseTest extends BasePage {

	@Test(testName = "check if a user can buy an item on the page", description = "This test case is adding a new item on the cart and then completing the purchase flow", priority = 1)
	public void checkUserCanBuyAnItemOnThePage() throws StreamWriteException, DatabindException, IOException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		ProductsPage productsPage = new ProductsPage(driver);
		String productPriceOnProductsPage = productsPage.addProduct(purchaseData.PRODUCTBACKPACK);

		topMenuPage topMenuPage = new topMenuPage(driver);
		topMenuPage.goToCart();

		CartPage cartPage = new CartPage(driver);
		String productPriceOnCart = cartPage.getItemPriceByItemName(purchaseData.PRODUCTBACKPACK);
		assertEquals(productPriceOnProductsPage, productPriceOnCart, "Price on products is not the same price on cart");
		cartPage.checkout();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.fillCheckoutForm(checkoutData.FIRSTNAME,checkoutData.LASTNAME,checkoutData.POSTALCODE);
		
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		String productPriceOnCheckoutOverviewPage= checkoutOverviewPage.getItemPriceByItemName(purchaseData.PRODUCTBACKPACK);
		assertEquals(productPriceOnCheckoutOverviewPage, productPriceOnCart, "Price on product is not the same price on overviewPage");

				
		assertEquals(checkoutOverviewPage.getPaymentInformation(), purchaseData.PAYMENTINFORMATION , "payment information does not correspond to the payment information defined");
		assertEquals(checkoutOverviewPage.getShippingInformation(), purchaseData.SHIPPINGINFORMATION , "shipping information does not correspond to the shipping information defined");
		assertEquals("$" + checkoutOverviewPage.getSubTotal(), productPriceOnProductsPage , "Price on product is not the same price on item total of overviewPage");
		assertEquals(checkoutOverviewPage.getTax(), purchaseData.TAX , "Tax value does not correspond to the tax defined");
		
		double total = checkoutOverviewPage.getSubTotal() + checkoutOverviewPage.getTax();
		assertEquals(checkoutOverviewPage.getTotal(), total , "total is now being well calculated");	
	}
}
