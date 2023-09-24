package SelTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ListCompare extends Common {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		WebDriver driver = openWeb("chrome", "https://rahulshettyacademy.com/seleniumPractise/#/offers");

//				Impwait(5);

		WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Wait the element to be ready to click
//		exwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr/th[1]")));

		// Click on the column to sort
//		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Get list of sorted column as original
//				List<WebElement> td=driver.findElements(By.xpath("//tr/td[1]"));
//		List<String> tdText = driver.findElements(By.xpath("//tr/td[1]")).stream().map(s -> s.getText())
//				.collect(Collectors.toList());
//		List<String> td2 = driver.findElements(By.xpath("//tr/td[1]")).stream()
//				.filter(e -> e.findElement(By.xpath("//tr/td[1]")).getText().collect(Collectors.toList());

//				ArrayList<String> td= new ArrayList(driver.findElements(By.xpath("//tr/td[1]")).Text);
//				List<String> tdSorted=td.stream().sorted().collect(Collectors.toList());

		// Sort the sorted column again
//		List<String> tdSorted = tdText.stream().sorted().collect(Collectors.toList());

		// Compare 2 list to check

//		Assert.assertNotEquals(tdText, tdSorted);
//		Assert.assertFalse(tdText.equals(tdSorted));

		// ****Test 2: find price of the Rice column

		// #########Find the column contain rice
		// Input the search item
		String search = "O".toLowerCase();
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(search);
//		List<String> rice;
		ArrayList<String> rice= new ArrayList<String>();
		ArrayList<String> ls= new ArrayList<String>();
		WebElement disable = driver.findElement(By.xpath("//a[@aria-label='Next']/parent::li[1]"));
//		Integer pagi = (driver.findElements(By.xpath("//ul[@aria-label='Pagination']//li"))).size();
		while(true)
		{
			driver.findElements(By.xpath("//tr/td[1]")).stream().map(s ->s.getText()).forEach(ls::add);
			driver.findElements(By.xpath("//tr/td[1]")).stream()
					.filter(s -> s.getText().toLowerCase().contains(search)).map(s ->s.getText()).forEach(rice::add);
			
			if(disable.getAttribute("class").isEmpty())
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
				Thread.sleep(500);
			}
			else {
				break;
			}
		}
//		do 
//		{
//			driver.findElements(By.xpath("//tr/td[1]")).stream().map(s ->s.getText()).forEach(ls::add);
//			driver.findElements(By.xpath("//tr/td[1]")).stream()
//					.filter(s -> s.getText().contains(search)).map(s ->s.getText()).forEach(rice::add);
//			
//			if(disable.getAttribute("class").isEmpty())
//			{
//				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
//				Thread.sleep(500);
//			}
//		}while(disable.getAttribute("class").isEmpty());
		out(rice.size());
		out(ls.size());
		Assert.assertEquals(rice.size(), ls.size());

		// ########### search and compare result with search text

		// Click to search item

//		Thread.sleep(500);
		// Get text of the item
//		List<String> result = driver.findElements(By.xpath("//tr/td[1]")).stream()
//				.filter(s -> s.getText().contains(search)).map(s -> s.getText()).collect(Collectors.toList());
//		result.forEach(s -> out(s));
		// Compare with the text
//		Assert.assertTrue(result.size() > 0);

		// Find the column contain Rice, if not click next

//		while (true)
//
//		{
//			try {
//				List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
//				WebElement nextbtn = driver.findElement(By.xpath("//a[@aria-label='Next']"));
//
//			} catch (NoSuchElementException ex) {
//				break;
//			}
//			WebElement disable = driver.findElement(By.xpath("//a[@aria-label='Next']/parent::li[1]"));
//			List<String> rice = driver.findElements(By.xpath("//tr/td[1]")).stream().filter(s->s.getText().contains("Cherry")).map(s -> getPrice(s)).collect(Collectors.toList());
//
//			if (rice.size() !=1 && disable.getAttribute("class").isEmpty()) {
////				By by xpath("//a[@aria-label='Next']");
////				exwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Next']")));
//				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
//				Thread.sleep(500);
//				
//
//			} else {
//				rice.forEach(a -> out(a));
//				break;
//			}
//		}

//		List<String> rice = driver.findElements(By.xpath("//tr/td[1]")).stream()
//		.filter(s -> s.getText().contains("Almond")).map(s -> s.getText()).collect(Collectors.toList());

		// ##Find the price respectively
//		rice.forEach(a -> out(a));
//		out("done");

	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
