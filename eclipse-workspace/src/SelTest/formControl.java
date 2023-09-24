package SelTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class formControl {

	public static void out(Object o){
	    System.out.println(o.toString());
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "E:\\Drive\\Automation test\\Selenium\\chromedriver.exe");
		
		//Invoking browser
		WebDriver driver = new ChromeDriver();
		
		String webHome="https://rahulshettyacademy.com/dropdownsPractise";
		
		//#### open web
		driver.get(webHome);
//		Thread.sleep(1000);
//		driver.close();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		//##### select dropdown
//		WebElement inputDDL = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		
//		Select DDL = new Select(inputDDL);
		
//		DDL.selectByIndex(3);
//		DDL.selectByValue("AED");
		
		
		
		//#### Select the city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//select input
		
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[contains(@text,'DEL')]")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(@text,'BKK')]")).click();
		String depVal=driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value");
		out(depVal);
//		Assert.assertEquals(depVal,"Delhi (DEL)" );
		
		//#### select dynamic options
//		driver.findElement(By.id("autosuggest")).sendKeys("us");
//		Thread.sleep(1000);
//		List<WebElement> list = driver.findElements(By.xpath("//*[@id='ui-id-1']//a[@class='ui-corner-all']"));
//		
//		for (WebElement item: list)
//		{
//			if(item.getText().equalsIgnoreCase("Cyprus"))
//			{
//				item.click();
//				break;
//			}
//		}
		
		
		
		//### checkbox
//		WebElement chbx = driver.findElement(By.xpath("//label[contains(text(),'Student')]//preceding::input[1]"));
//		out(chbx.isSelected());
//		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Student')]//preceding::input[1]")).isSelected());
//		driver.findElement(By.xpath("//label[contains(text(),'Student')]//preceding::input[1]")).click();
////		out(chbx.isSelected());
//		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Student')]//preceding::input[1]")).isSelected());
		
		//Select date ui
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();
		Thread.sleep(2000);
		WebElement pickDate = driver.findElement(By.xpath("//*[contains(@data-handler,'selectDay') and @data-month='7' and @data-year='2023']//a[text()='18']"));
		pickDate.click();
		
		
		Thread.sleep(1000);
		out(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).getAttribute("value"));
		
		SoftAssert softAssert = new SoftAssert();
		// fidn the disable and enable control
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5")) 
		{
			out("true");
			softAssert.assertTrue(false);
			
		}
		else
		{
			out("false");
			softAssert.assertTrue(true);
			
		}
		Thread.sleep(1000);
		//##### click dropdown value 
		WebElement passgers= driver.findElement(By.id("divpaxinfo"));
				passgers.click();
//					wait to show ddl
				Thread.sleep(500);
//				 click 2 adult, click 2 child 
				int i = 1;
				while (i<2)
				{
					driver.findElement(By.id("hrefIncAdt")).click();
					i++;
				}
				
				for (i=1; i<3; i++)
				{
					driver.findElement(By.id("hrefIncChd")).click();
				}
				driver.findElement(By.id("btnclosepaxoption")).click();
				out(passgers.getText());
			
			// click button search
				driver.findElement(By.xpath("//*[contains(@id,'FindFlights')]")).click();
				
				
				Thread.sleep(500);
//		driver.quit();
		
	}

}
