package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUI implements ITestListener {
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test is started");
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is passed");
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is failed");
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("This is on test start");
	}

}
