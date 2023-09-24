package SelTest;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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

public class Links extends Common {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome","https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		List<WebElement> links= driver.findElements(By.xpath("//a[not(@href=\"#\")]"));
		ArrayList<String> badLinks = new ArrayList();
		for(int i=0; i<links.size();i++)
		{
			String url = links.get(i).getAttribute("href");
			out(url);
			if(!url.isEmpty()&& !url.isBlank() ) 
			{
				HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int resp = conn.getResponseCode();
				out(resp);
				if(resp >400)
				{
					badLinks.add(url);
				}
			}
			
		}
		
		for(String link: badLinks)
		{
			out(link);
		}
		
//		String url = driver.findElement(By.xpath("//a[contains(@href,'broken')]")).getAttribute("href");
//		out(url);
//		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int resp = conn.getResponseCode();
		
		Thread.sleep(1000);
		driver.close();
	
}
}
