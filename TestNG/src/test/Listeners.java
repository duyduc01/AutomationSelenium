package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

//import org.testng.ITestListener;

public class Listeners implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("listener success");
	}
}
