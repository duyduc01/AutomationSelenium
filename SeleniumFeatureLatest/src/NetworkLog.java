import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.Request;
import org.openqa.selenium.devtools.v116.network.model.Response;

public class NetworkLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"E:\\Drive\\Automation test\\Selenium/chromedriver.exe");// t530

		ChromeOptions options = new ChromeOptions();
		 
		// Launch ChromeDriver with the options
        ChromeDriver driver = new ChromeDriver(options);
		
		
		

		DevTools devTools = driver.getDevTools();

		devTools.createSession();// create session
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request -> 
		{
			Request req = request.getRequest();
			System.out.println(req.getUrl() );
			req.getHeaders();
		});
		
		devTools.addListener(Network.responseReceived(),response ->
		{
			Response res = response.getResponse();
//			System.out.println(res.getUrl() );
			System.out.println(res.getStatus() );
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();
		
		
	}

}
