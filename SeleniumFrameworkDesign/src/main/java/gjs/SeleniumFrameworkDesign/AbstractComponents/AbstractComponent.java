package gjs.SeleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gjs.SeleniumFrameworkDesign.pageobjects.CartPage;
import gjs.SeleniumFrameworkDesign.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderBtn;
	
	//##go to cart page
	public CartPage goToCartPage()
	{
		cartBtn.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	//##go to order page
		public OrderPage goToOrderPage()
		{
			orderBtn.click();
			OrderPage orderPage = new OrderPage(driver);
			return orderPage;
		}
	
	//wait element
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	//wait web element
		public void waitForWebElementToAppear(WebElement findBy)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	
	//wait element
		public void waitForManyElementsToAppear(List<WebElement> e)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElements(e));
		}
	
	public void waitForElementToDisappear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.invisibilityOf(driver.findElement(findBy)));
	}

}
