package testng_programs;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
	    // not implemented
		System.out.println("On test start method. Executes before every test.");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		System.out.println("On test success method");
	  }
	
	public void onTestFailure(ITestResult result) {
	    // not implemented
		System.out.println("On test failed method");
	  }
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		System.out.println("On test skipped method");
	  }
	
	public void onFinish(ITestContext context) {
	    // not implemented
		System.out.println("On Finish method");
	  }
	
	public void onStart(ITestContext context) {
	    // not implemented
		System.out.println("On start method. Executes only once");
	  }
	
}
