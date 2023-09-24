package gjs.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gjs.SeleniumFrameworkDesign.pageobjects.CartPage;
import gjs.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import gjs.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import gjs.SeleniumFrameworkDesign.pageobjects.OrderPage;
import gjs.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import gjs.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String pName = "zara";

	@Test(dataProvider = "getData", groups = "testDataProvider")
	public void submitOrder(HashMap<String, String> input) throws Exception {

		// #### login
		ProductCatalogue productCatalogue = langdingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		// ####Get products

		productCatalogue.addProductToCart(input.get("pName"));
		CartPage cartPage = productCatalogue.goToCartPage();

		// #### Get products added to cart

		Boolean match = cartPage.VerifyingProductDisplay(input.get("pName"));
		Assert.assertTrue(match);

		// ###Checkout page
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("vietnam");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirm = confirmationPage.confirmMessage();
		Assert.assertTrue(confirm.equalsIgnoreCase("Thankyou for the order."));
//		System.out.println(confirm);

	}
	
	

	
	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() throws Exception {
		ProductCatalogue productCatalogue = langdingPage.loginApplication("duyduc01@gmail.com", "Daihocngoai20");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Boolean match = orderPage.VerifyingOrderDisplay(pName);
		Assert.assertTrue(match);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
//		return new Object[][] { { "duyduc01@gmail.com", "Daihocngoai20", "zara" },
//				{ "duyduc01@gmail.com", "Daihongoai20", "zara" } };
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "duyduc01@gmail.com");
//		map.put("password", "Daihocngoai20");
//		map.put("pName", "zara");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "duydc01@gmail.com");
//		map1.put("password", "Daihocngoai20");
//		map1.put("pName", "zara");
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\gjs\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
