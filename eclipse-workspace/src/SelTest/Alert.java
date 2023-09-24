package SelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert extends Common {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		// chromedriver.exe => chrome browser
		
		
		// open web
		WebDriver driver = openWeb("chrome", "https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement name= driver.findElement(By.id("name"));
		WebElement alert = driver.findElement(By.id("alertbtn"));
		name.sendKeys("Duc");
		alert.click();
		sl(1000);
		out(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}
