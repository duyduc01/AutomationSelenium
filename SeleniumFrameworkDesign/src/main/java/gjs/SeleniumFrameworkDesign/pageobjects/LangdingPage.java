package gjs.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import gjs.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class LangdingPage extends AbstractComponent{

	WebDriver driver;
	
	public LangdingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	
	
	//Page Factory
	@FindBy(xpath="//*[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//*[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//*[@id='login']")
	WebElement submit;
	
	@FindBy(xpath="//*[contains(@class,'ngx-toastr')]")
	WebElement tMessage;
	

	
	public ProductCatalogue loginApplication(String email, String password) throws Exception
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		System.out.println(getErrorMessage());
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String login(String email, String password) throws Exception
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		String tMessage = getErrorMessage();
		
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return tMessage;
	}
	
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(tMessage);
		
		return tMessage.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
