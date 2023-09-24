package gjs.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import gjs.SeleniumFrameworkDesign.pageobjects.CartPage;
import gjs.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import gjs.TestComponents.BaseTest;

//@Listeners(gjs.TestComponents.Listeners.class)
public class ErrorValidations extends BaseTest {
	
	@Test (groups= {"error"}, retryAnalyzer=gjs.TestComponents.Retry.class)
	public void LoginErrorValidation() throws Exception
	{ 
		
		langdingPage.loginApplication("dyduc01@gmail.com", "Daihocngoai20");
//		System.out.println(langdingPage.getErrorMessage());
		Assert.assertTrue(langdingPage.getErrorMessage().contains("Incorrect"));
		
		// ####Get products
//		String pName = "zara";

	}

	
	
	@Test 
	public void ProductErrorValidation() throws Exception
	{
		

		// #### login
		ProductCatalogue productCatalogue = langdingPage.loginApplication("duyduc01@gmail.com", "Daihocngoai20");
		List<WebElement> products = productCatalogue.getProductList();
		// ####Get products
		String pName = "zara";
		productCatalogue.addProductToCart(pName);
		CartPage cartPage =productCatalogue.goToCartPage();

		// #### Get products added to cart
		
		Boolean match = cartPage.VerifyingProductDisplay(pName);
		Assert.assertTrue(match);
		
		


	}
}
