import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Drive\\Automation test\\Selenium/chromedriver.exe");// t530
		String fileName ="/FileImport-BkavIVAN-(BTF.v300).pdf";
		//set download location and copy file download to location of project
		String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		

		// Launch ChromeDriver with the options
		driver = new ChromeDriver(options);
		Impwait(1);
		
		driver.get("https://smallpdf.com/excel-to-pdf");
		driver.findElement(By.xpath("//span[.='Choose Files']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("\"C:\\Users\\Administrator\\Documents\\fileUpload.exe\"");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Download']")));
		
		driver.findElement(By.xpath("//span[normalize-space()='Download']")).click();
		//Cannot sleep when download file
		Thread.sleep(5000);
		File f=new File(downloadPath + fileName);
		if(f.exists())// check file download
		{
			out("file download successed");
			driver.close();
		}
		else {
			out("file download failed");
			driver.close();
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
