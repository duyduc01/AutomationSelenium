import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"E:\\Drive\\Automation test\\Selenium\\chromeDriver/chromedriver.exe");// t530

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();// create session

		// send commands to CDP
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));

//		devTools.send(Emulation.setDe);
				
				
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		// click menu
//		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector(".navbar-toggler")).click();

		Thread.sleep(3000);

//		driver.findElement(By.xpath("//a[normalize-space()='Library']")).click();
		driver.findElement(By.linkText("Library")).click();

	}

}