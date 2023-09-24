package SelTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Table extends Common {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome","https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement table = driver.findElement(By.xpath("//div[@class='tableFixHead']"));
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		
		List<WebElement> amount = driver.findElements(By.xpath("//*[@class='tableFixHead']//td[4]"));
		int sum=0;
		int i;
		for(i=0; i< amount.size(); i++ )
		{
			int value = Integer.parseInt(amount.get(i).getText());
			sum=sum+value;
			
			
		}
		out(i +"//"+amount.size());
		
		String[] Total = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":");
		int sumTotal= Integer.parseInt(Total[1].trim());
		out(sum + "//" + sumTotal);
		Assert.assertEquals(sum,sumTotal);
		
	}

}
