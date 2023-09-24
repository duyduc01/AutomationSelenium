package gjs.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import gjs.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement inputCountry;
	
	@FindBy(xpath="//*[contains(@class,'ta-results')]//button")
	List<WebElement> listCountries;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement submit;
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(inputCountry, "vietnam").build().perform();
		waitForManyElementsToAppear(listCountries);
//		waitForElementToAppear();
//		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[contains(@class,'ta-results')]//button"))));
		listCountries.stream().filter(p -> p.getText().toLowerCase().contains("vietnam")).findFirst().ifPresent(p -> {
			p.click();
//		List<WebElement> country = driver.findElements(By.xpath("//*[contains(@class,'ta-results')]//button"));
//		country.stream().filter(p -> p.getText().toLowerCase().contains("vietnam")).findFirst().ifPresent(p -> {
//			p.click();
		});
		
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}

}
