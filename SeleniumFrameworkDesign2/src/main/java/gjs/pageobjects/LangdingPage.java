package gjs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LangdingPage {

	WebDriver driver;
	
	public LangdingPage(WebDriver driver)
	{
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
}
