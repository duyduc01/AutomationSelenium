package SelTest;

import java.sql.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartEcommerce extends Common {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = openWeb("chrome","https://rahulshettyacademy.com/seleniumPractise/");
		
//		Impwait(5);
		
		WebDriverWait exwait= new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Set condition of products
		String[] searchitems = {"Cucumber","Carrot","Beans"};
		
		//convert array to array list
		List<String> scitems = Arrays.asList(searchitems);
		
		// Get products in cart and click
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		exwait.until(ExpectedConditions.visibilityOfAllElements(products));
		
		//check each item name
		int j=0;
		for(int i=0; i<products.size();i++)
		{
			//convert name of product 
			String productsitem[] = products.get(i).getText().split("-");
			String productname = productsitem[0].trim();
			//check if search item contain name of product
			if(scitems.contains(productname))
			{
//				out(productname);
				WebElement btn = driver.findElements(By.xpath("//div[contains(@class,'product-action')]//button")).get(i);
				
				btn.click();
				j++;
				
				if (j==searchitems.length)
				{
					out("break");
					break;
				}
//				if (btn.getText().contains("ADD TO CART"))
//				{
//					btn.click();
//					j++;
//					
//					if (j==searchitems.length)
//					{
//						break;
//					}
//				}
//				else
//				{
//					exwait.until(ExpectedConditions.invisibilityOfElementWithText((By) btn, "ADD TO CART"));
//				}
				
				
			}
			
		}
//		 go to cart 
		WebElement cartnumber = driver.findElement(By.xpath("//*[contains(@class,'cart-info')]//strong"));
		exwait.until(ExpectedConditions.textToBePresentInElement(cartnumber,"3"));
		WebElement gotocart = driver.findElement(By.xpath("//*[contains(@class,'cart-icon')]//img"));
		gotocart.click();
		exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart-preview active')]")));
		driver.findElement(By.xpath("//div[contains(@class,'cart-preview')]//button[contains(text(),'CHECKOUT')]")).click();
		//		while(true)
//		{
//			if (cartpreview != null)
//			{
//				c
//				break;
//			}
//			else
//			{
//				exwait.until(ExpectedConditions.visibilityOf(cartpreview));
//			}
//		}
		//go to checkout and apply promo
		exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'promoCode')]")));
		WebElement cartpromo = driver.findElement(By.xpath("//*[contains(@class,'promoCode')]"));
		cartpromo.sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//*[contains(@class,'promoBtn')]")).click();
	exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'promoInfo')]")));
	driver.findElement(By.xpath("//*[contains(text(),'Place')]")).click();
	
	
	
	
		
		
		
		
		
		
		
		
		
	exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Proceed')]")));
	out("done");
		driver.quit();
		
	}

}
