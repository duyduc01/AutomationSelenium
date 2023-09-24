package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {
	

	@Parameters({"param"})
	@Test
	public void Demo2(String pa)
	{
		System.out.println("day2.demo2");
		System.out.println(pa);
	}
	
	@Test
	public void Demo3()
	{
		System.out.println("day22");
	}

}
