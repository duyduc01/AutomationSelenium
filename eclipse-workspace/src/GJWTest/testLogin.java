package GJWTest;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class testLogin {
	// print something
	public static void out(Object o){
	    System.out.println(o.toString());
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		

		
		
		// TODO Auto-generated method stub
		// chromedriver.exe => chrome browser
				String userDir = System.getProperty("user.dir");
//				System.out.println(userDir);
				out(userDir);
//				System.setProperty("webdriver.chrome.driver", userDir + File.separator + "chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", "E:\\Cloud\\Automation test\\Selenium\\chromedriver.exe");
			
				//Invoking browser
				WebDriver driver = new ChromeDriver();
				
				String webHome="https://www.ganjingworld.com";
//				WebElement btnLogIn = driver.findElement(By.xpath("//button[contains(.,'Sign in')]"));
//				WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]"));
//				WebElement pass = driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]"));
//				WebElement btnSignIn = driver.findElement(By.xpath("//button[contains(.,'SIGN')]"));

				
				//#### open web
				driver.get(webHome);
				Thread.sleep(1000);
//				WebElement btnLogIn = driver.findElement(By.xpath("//button[contains(.,'Sign in')]"));
//				btnLogIn.click();
				// Implicit wait - 2 seconds
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				
//				WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]"));
//				WebElement pass = driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]"));
				
//				email.sendKeys("duyduc01@gmail.com");
//				pass.sendKeys("123abc@a");
				
//				WebElement btnSignIn = driver.findElement(By.xpath("//button[contains(.,'SIGN')]"));
//				btnSignIn.click();
				
//				Thread.sleep(1000);
				
				String postTitle = driver.findElement(By.xpath("(//*[contains(@class,'postTitle')])[1]")).getText();
				String[] postTitleSplit = postTitle.trim().split(" ");
//				String posTitleTrim = postTitle.trim();
//				out(Arrays.deepToString(postTitleSplit));
				for(int i=0; i<postTitleSplit.length; i++ )
				{
					out(postTitleSplit[i]);
				}
//				out(postTitleSplit[0]);
//				out(Arrays.toString(postTitleSplit));
				driver.quit();
				
				
				
	}

}
