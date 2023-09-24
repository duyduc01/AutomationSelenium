package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	@Test (groups= {"now"})
	public void WebloginHomeloan()
	{
		System.out.println("WebloginHomeloangroupnow");
	}
	@Parameters({"param"})
	@Test
	public void MobileloginHomeloan(String param)
	{
		System.out.println(param);
	}

}
