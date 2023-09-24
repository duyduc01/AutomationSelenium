package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Common {
	@BeforeTest
	public void beforetest()
	{
		System.out.println("beforeTest");
	}
	
	
		public void out(Object o) {
			System.out.println(o.toString());
		}

		@AfterTest
		public void aftertest()
		{
			System.out.println("aftertest");
		}
		
//		int x;
//		
//		public Common(int x)
//		{
//			this.x=x;
//		}
//		public int increase()
//		{
//			x=x+1;
//			return x;
//		}
		
		
}
