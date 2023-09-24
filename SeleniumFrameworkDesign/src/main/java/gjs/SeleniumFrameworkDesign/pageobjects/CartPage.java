package gjs.SeleniumFrameworkDesign.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gjs.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> cartItems;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkout;
	
	By cartProducts= By.xpath("//div[@class='cartSection']//h3");
	
	public Boolean VerifyingProductDisplay(String pName)
	{
		waitForElementToAppear(cartProducts);
		Boolean match = cartItems.stream().anyMatch(p -> p.getText().toLowerCase().contains(pName));
		return match;
		
		
	}
	
	
	public CheckoutPage goToCheckout()
	{
		checkout.click();
		return new CheckoutPage(driver);
	}
	

}
