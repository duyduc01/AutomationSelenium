package SelTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar extends Common {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome","https://www.path2usa.com/travel-companion/");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions move = new Actions(driver);
		//Wait for input to be ready to click
		expWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='form-field-travel_comp_date']")));

//		expWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_date']")));
		 WebElement inputCalendar = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		 // Move element to view to avoid google ads and click
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", inputCalendar);
			expWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_date']")));
			Thread.sleep(1000);
		 inputCalendar.click();
//		js.executeScript("arguments[0].click();", inputCalendar);

		// wait for PU calendar ready
//		expWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'cur-year')]")));
//		expWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'cur-month')]")));
		
//		WebElement year1 = driver.findElement(By.xpath("//*[contains(@class,'cur-year')]"));
//		WebElement month= driver.findElement(By.xpath("//*[contains(@class,'cur-month')]"));
		WebElement date=driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
//		WebElement nextbtn = driver.findElement(By.xpath("//span[@class='flatpickr-next-month']"));
		String[] con= {"March", "2024","30"};
		while (true)
		{
			try {
				WebElement year1 = driver.findElement(By.xpath("//*[contains(@class,'cur-year')]"));
				WebElement month= driver.findElement(By.xpath("//*[contains(@class,'cur-month')]"));
				WebElement nextbtn = driver.findElement(By.xpath("//span[@class='flatpickr-next-month']"));
			} catch(NoSuchElementException ex) {
				break;
			}
//			driver.navigate().refresh();
			
			if(driver.findElement(By.xpath("//*[contains(@class,'cur-month')]")).getText().contains(con[0])  &&
					driver.findElement(By.xpath("//*[contains(@class,'cur-year')]")).getAttribute("value").contains(con[1]) )
			{
				
				break;
			}else {
				driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
				Thread.sleep(500);
			}
		}
		   
//		while(!driver.findElement(By.xpath("//*[contains(@class,'cur-year')]")).getAttribute("value").contains("2024")   )
//			while(!driver.findElement(By.xpath("//*[contains(@class,'cur-month')]")).getText().contains("February")   )
//		{
//				
//			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
//			out(driver.findElement(By.xpath("//*[contains(@class,'cur-year')]")).getAttribute("value"));
//			out(driver.findElement(By.xpath("//*[contains(@class,'cur-month')]")).getText());
//			
//			
//		}
//		
		String locator = "//span[contains(@class,'flatpickr-day') and contains(@aria-label,'"+ con[0]+"')]";
//		out(locator);
		List<WebElement> days = driver.findElements(By.xpath(locator));
//		ArrayList<>
		for(int i=0; i<days.size();i++)
		{
			String text= driver.findElements(By.xpath(locator)).get(i).getText();
//			out(text);
			if(text.contains("30"))
			{
				driver.findElements(By.xpath(locator)).get(i).click();
				break;
			}
		}
//		out(inputCalendar.get)
//		https://stackoverflow.com/questions/57512299/selenium-how-to-avoid-staleelementreferenceexception-when-looping-through-a-set
		out(inputCalendar.getAttribute("value"));
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,	new File("E:\\Drive\\Automation test\\Selenium\\screenshot/screenshot.jpg"));
//		
		Thread.sleep(1000);
		driver.close();
	}
	
//	public static boolean retryFind(By by) {
//	    boolean result = false;
//	    int attempts = 0;
//	    while(attempts < 2) {
//	        try {
//	            driver.findElement(by);
//	            result = true;
//	            break;
//	        } catch(StaleElementReferenceException e) {
//	        }
//	        attempts++;
//	    }
//	    return result;
//	}
	
}
