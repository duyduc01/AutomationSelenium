package SelTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frame extends Common{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome","https://jqueryui.com/droppable/");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		act.dragAndDrop(drag, drop).build().perform();
		driver.switchTo().defaultContent();
		out(driver.getCurrentUrl());
		driver.quit();		
		

	}

}
