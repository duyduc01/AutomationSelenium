package SelTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screenshot extends Common {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = openWeb("chrome","https://courses.rahulshettyacademy.com/courses");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
		
		
		// ### open child window
		
		
//		String url = driver.findElement(By.xpath("(//*[contains(@data-role,'course')])[1]")).getAttribute("href");
//		driver.switchTo().newWindow(WindowType.TAB);
//		out(url);
//		driver.get(url);
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> iter = windows.iterator();
//		String parentW = iter.next();
//		String ChildW = iter.next();
//		driver.close();
//		driver.switchTo().window(parentW);
//		driver.findElement(By.xpath("(//*[contains(@class,'course-listing')])[1]")).click();
		
		
		
		
		//#### get screenshot of webelement
		WebElement course = driver.findElement(By.xpath("(//*[contains(@class,'course-listing')])[1]"));
		File file = course.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("test.png"));
		
		
		
		//##### get width and height
		out(course.getRect().getDimension().getHeight());
		out(course.getRect().getDimension().getWidth());
		
		
		
		
		}

}
