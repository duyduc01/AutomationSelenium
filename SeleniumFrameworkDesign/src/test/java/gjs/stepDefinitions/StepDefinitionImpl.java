package gjs.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import gjs.SeleniumFrameworkDesign.pageobjects.CartPage;
import gjs.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import gjs.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import gjs.SeleniumFrameworkDesign.pageobjects.LangdingPage;
import gjs.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import gjs.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

	public LangdingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) throws Exception {
		productCatalogue = langdingPage.loginApplication(username, password);
	}

//    When I add product <productName> to Cart
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

	}

//    And Checkout <productName> and submit the order
	@When("^Checkout (.+) and submit the order$")
	public void Checkout__submit_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();

		// #### Get products added to cart

		Boolean match = cartPage.VerifyingProductDisplay(productName);
		Assert.assertTrue(match);
		// ###Checkout page
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("vietnam");
		confirmationPage = checkoutPage.submitOrder();

	}
	
	

//	Then"THANKYOU FOR THE ORDER." mesage is displayed on ConfirmationPage
	@Then("{string} mesage is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirm = confirmationPage.confirmMessage();
		Assert.assertTrue(confirm.equalsIgnoreCase(string));
		driver.close();
	}
	

//	Then"Incorrect..." mesage is displayed on ConfirmationPage
	@Then("{string} error mesage is displayed on ConfirmationPage")
	public void error_message_displayed_confirmationPage(String string)
	{
		Assert.assertTrue(langdingPage.getErrorMessage().contains("Incorrect"));
		driver.close();
	}

}
