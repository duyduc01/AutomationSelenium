package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day3 {
	
	@Test
	public void WebloginCarloan()
	{
		System.out.println("WebloginCarloan");
	}
	
	@Test
	public void MobileloginCarloan()
	{
		System.out.println("MobileloginCarloan");
	}
	@BeforeTest
	
	public void MobileloginCarloan1()
	{
		System.out.println("beforeTestday3");
	}
	@Test
	public void APIloginCarloan()
	{
		System.out.println("APIloginCarloan");
	}

}
