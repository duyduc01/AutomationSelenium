package SelTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scope extends Common {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome","https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
//		List<WebElement> links = driver.findElements(By.xpath("//a"));
//		out(links.size());
		//++ open windows
		WebElement foDiv = driver.findElement(By.xpath("(//*[@id='gf-BIG']//ul)[1]"));
//		out(foDiv.findElements(By.xpath(".//a")).size());
		List<WebElement> links = foDiv.findElements(By.xpath(".//a"));
		String keyChrod = Keys.chord(Keys.CONTROL, Keys.ENTER);
		int i = 0;
		for (i=0; i<links.size();i++)
		{
//			out(links.get(i).getAttribute("href"));
			if(!links.get(i).getAttribute("href").contains("https://rahulshettyacademy.com/AutomationPractice/#"))
				{
				links.get(i).sendKeys(keyChrod);
				}
		}
//		out(i + "window opened");
		expWait.until(ExpectedConditions.numberOfWindowsToBe(i));
		

		//++switch to each windows and get title
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
//		out(iter);
		//store parent windows in variable
		String parWindown = driver.getWindowHandle();
		ArrayList<String> paTitles= new ArrayList();
		while(iter.hasNext() )
		{
			String chilWindow=iter.next();
			if(!parWindown.equals(chilWindow))
			{
				driver.switchTo().window(chilWindow);
				paTitles.add(driver.getTitle());
				driver.close();
			}
			driver.switchTo().window(parWindown);
		}
//print page title
		
		for (String val: paTitles)
		{
			out(val);
		}
//		driver.close();
	}

}
