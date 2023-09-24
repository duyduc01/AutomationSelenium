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

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']//td[2]")
	List<WebElement> orderItems;
	
//	@FindBy(xpath="//button[normalize-space()='Checkout']")
//	WebElement checkout;
	
	By orderProducts= By.xpath("//tr[@class='ng-star-inserted']//td[2]");
	
	public Boolean VerifyingOrderDisplay(String pName)
	{
		waitForElementToAppear(orderProducts);
		Boolean match = orderItems.stream().anyMatch(p -> p.getText().toLowerCase().contains(pName));
		return match;
		
		
	}
	
	

	

}
