import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.fetch.Fetch;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.Request;
import org.openqa.selenium.devtools.v116.network.model.Response;
//import org.openqa.selenium.devtools.v85.log.model.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class LogsCapture {
	
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Drive\\Automation test\\Selenium/chromedriver.exe");// t530

		ChromeOptions options = new ChromeOptions();
		

		// Launch ChromeDriver with the options
		driver = new ChromeDriver(options);
		Impwait(1);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		
		driver.findElement(By.xpath("//a[normalize-space()='Browse Products']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Appium']")).click();
		//button[normalize-space()='Add to Cart']
		driver.findElement(By.xpath("//button[normalize-space()='Add to Cart']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("n");

		LogEntries log=driver.manage().logs().get(LogType.BROWSER); // Get log object
		List<LogEntry>logs = log.getAll();//get all logs
		
		for(LogEntry e: logs)//iterating through list and printing each log message
		{
			out(e.getMessage());
		}
		
		
		
		

	}
	
	public static void out(Object o) {
		System.out.println(o.toString());
	}
	public static void Impwait(int i)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}

}
