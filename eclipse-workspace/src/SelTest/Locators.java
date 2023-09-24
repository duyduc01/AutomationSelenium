package SelTest;

import java.security.Provider.Service;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions ;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//######add chrome user agent to bypass chromedriver
		

	    ChromeOptions options = new ChromeOptions();
	    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36";
	    options.addArguments(userAgent);
//	    new ChromeDriver(options);
		
		//##### set headless browser
		
		// set chrome as Headless
//		options.addArguments("--headless=new");
//		`addArguments("--headless=new")`.
		//Invoke browser
		// TODO Auto-generated method stub
		
		// chromedriver.exe => chrome browser
		System.setProperty("webdriver.chrome.driver", "E:\\Cloud\\Automation test\\Selenium\\chromedriver.exe");
	
		//Invoking browser
		WebDriver driver = new ChromeDriver();
		
	
		
		// open web
		driver.get("https://www.ganjingworld.com/");
		Thread.sleep(1000);
		// Implicit wait - 2 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Find locators of login page
//		driver.findElement(By.id("user_name")).sendKeys("phuong_cdvn");
		
//		driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("phuong_cdvn");
//		driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("alo");
//		driver.findElement(By.cssSelector("input#user_name")).clear();
		//driver.findElement(By.name("email")).sendKeys("duyduc01@gmail.com");
//		driver.findElement(By.className("password")).sendKeys("Daihocngoai2");
//		
//		String toast_mess = driver.findElement(By.cssSelector("span.text-with-icon")).getText();
		//System.out.println(toast_mess);
		
		WebElement regLink = driver.findElement(By.xpath("//a[contains(@href,'sign_up')]"));
//		String LogInLink2 = driver.findElement(By.xpath("//a[@data-test-id='login-button']")).getAttribute("href");
//		System.out.println(LogInLink2);
		// click to login page
		regLink.click();
		//Sleep wait for some seconds loading//*[@id="TopElement"]/header/div/div[1]/div/button[2]
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[contains(@value,'email')]")).click();
//		driver.findElement(By.xpath("//button[contains(@value,'google')]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.findElement(By.xpath("//a[contains(@href,'login')]")).click();


		//fill to login page
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("duyduc01@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='password-container']/input")).sendKeys("Daihocngoai20");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//input[contains(@class,'btn-primary')]")).click();
		
		
//		Thread.sleep(1000);
		//div[contains(@data-email,'duyduc01@gmail.com')]
		
//		driver.findElement(By.xpath("//a[contains(@data-test-id,'google')]")).click();

		
		
		//#### log in to google
		
		
		
		
//		Thread.sleep(3000);


//		driver.findElement(By.xpath("//input[containts(@type,'checkbox')]")).click();
//		Wait max 20 seconds so that iframe validate load
//		String pTitle = driver.getTitle();
//		System.out.println(pTitle);
//		iframe = driver.findElement(By.xpath("//iframe[@name='Just a moment...']"));
//		driver.switchTo().frame(driver.findElement(By.id("iframe")));
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe")));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@class,'ctp-checkbox-label')]"))).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ctp-checkbox-label']//span[@class='mark']"))).click();

	}

}
