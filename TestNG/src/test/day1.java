package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 extends Common {



//public day1(int x) {
//		super(x);
//		// TODO Auto-generated constructor stub
//	}
//
//@Test
//public void testRun()
//{
//	Common common = new Common(3);
////	int a = 3;
//	out(common.increase());
//}




//	@Parameters({"param","url"})
	@Test(dataProvider="getData")
	public void Day11(String u, String p)
	{
		System.out.println("day1-1");
		System.out.println(u);
		System.out.println(p);
	}
	
@BeforeMethod (groups= {"now"},timeOut=4000)
	
	public void MobileloginCarloan11()
	{
		out("day11@BeforeMethod1groupnow");
	}

@AfterTest (groups= {"now"})
	
	public void MobileloginCarloan1()
	{
		System.out.println("@AfterTestgroupnow");
	}
	
	@Test(dependsOnMethods={"MobileloginCarloan1","MobileloginCarloan11"},enabled=false)
	public void Demo1()
	{
		System.out.println("day12");
	}
	
	

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		data[0][0]="1user";
		data[0][1]="1pass";
		data[1][0]="2user";
		data[1][1]="2pass";
		data[2][0]="3user";
		data[2][1]="3pass";
		return data;
		
	}
	
	
}
