package test;

import org.testng.annotations.Test;

public class ExtendCommon2 extends Common {

	@Test
	public void test()
	{
//		out("test");
		
		Common2 cm2= new Common2(3);//call the constructor => as contructor assign to class variable, it will be the class variable then go to any method of this objects cm2
		int x=3;
//		out(cm2.increase());
//		System.out.println(cm2.increase());
		out(cm2.multiply());
		
	}
	

	
//	@Test
//	public void testRun()
//	{
//		int x=3;
//		
//		ExtendCommon2 c=new ExtendCommon2(3);
//		
//		System.out.println(c);
//	}
	
}
