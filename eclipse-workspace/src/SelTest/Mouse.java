package SelTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mouse extends Common {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome", "https://www.amazon.fr");
		WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sp-cc-accept']")));
		driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

		// Mouse
		Actions act = new Actions(driver);
		// == move mouse to element
//		Actions act = new Actions(driver);

//		act.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
//		
//		exwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@style,'block') and contains(@class,'coreFlyout')]")));

		// -- move mouse and click search

		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("mobile").build().perform();
		// quite
		Thread.sleep(1000);
//		out("action done");
		driver.quit();

	}

}
