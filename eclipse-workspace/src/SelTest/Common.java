package SelTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Common {
	public static void out(Object o) {
		System.out.println(o.toString());
	}

	static WebDriver driver;

	public static WebDriver openWeb(String browser, String url) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Drive\\Automation test\\Selenium/chromedriver.exe");// t530
//			System.setProperty("webdriver.chrome.driver", "D:/Selenium/chrome-win64/chromedriver.exe");
			// Set chromeoptions
			ChromeOptions options = new ChromeOptions();
	        options.setAcceptInsecureCerts(true);
	        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

	        
			
			// Invoking browser
			driver = new ChromeDriver(options);
			driver.navigate().to(url);
	        driver.manage().window().maximize();
	        
	        
	        
		} else if (browser.equals("firefox")) {
			System.out.println("browser firefox not supported");
			Assert.assertTrue(false);
		} else if (browser.equals("edge")) {
			System.out.println("browser edge not supported");
			Assert.assertTrue(false);
		}
		return driver;

	}

	public static void sl(Integer t) throws InterruptedException {
		Thread.sleep(t);
	}
	
	
	public static void Impwait(int i)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}

}
