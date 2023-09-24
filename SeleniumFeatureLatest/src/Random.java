import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


public class Random {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Drive\\Automation test\\Selenium/chromedriver.exe");// t530

		ChromeDriver driver=new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		        devTools.createSession();

		//get coordinates using Google Earth

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("latitude", 40);

		param.put("longitude", 3);

		param.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", param);

		driver.get("https://www.facebook.com/");

		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);

		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

		driver.findElement(By.cssSelector(".our-story-card-title")).getText();

		System.out.println(driver.findElement(By.xpath("//div[@class='our-story-card-text']/h1")).getText());

		}

}
