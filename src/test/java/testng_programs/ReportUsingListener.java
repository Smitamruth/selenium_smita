package testng_programs;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners
public class ReportUsingListener implements ITestListener {

	public ExtentSparkReporter sparkReporter; 	// UI of the report.
	public ExtentReports extent;	// populate common info of the report.
	public ExtentTest test; 	// creating test case entries in the report and update status of the test methods.

	public void onStart(ITestContext context) {
		
		//do not hardcode data; let the report be created with timestamp in its name.
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html"); 	// specific location.
	    sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report.
	    sparkReporter.config().setReportName("Functional testing"); 	// Name of the report.
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);  //combines UI along with the populated info.
	    
	    //no need to hard code. Get this info at runtime.
	    extent.setSystemInfo("Computer Name", "localhost");
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("TesterName", "Smita");
	    extent.setSystemInfo("OS", "Windows 10");
	    extent.setSystemInfo("Browser Name", "Chrome");
	    
	  }
	
	public void onTestStart(ITestResult result) {
	    // not implemented
		System.out.println("On test start method. Executes before every test.");
	  }
	
	public void onTestSuccess(ITestResult result) {
		//show test case names and test case ID ==> so that if you have 100s of test cases, then its easy to understand.
	    test = extent.createTest(result.getName()); 	// create a new entry in the report.
	    test.log(Status.PASS, "Test passed is: "+result.getName());	 	// update status p/f/s.
	    
	  }
	
	public void onTestFailure(ITestResult result) {
		
		//add screenshot in report.
		test = extent.createTest(result.getName()); 	// create a new entry in the report.
		test.log(Status.FAIL, "Test failed is: "+result.getName());	 	// update status p/f/s.
		test.log(Status.FAIL, "Test failed cause is: "+result.getThrowable());	 	// update cause of failure.
		
	  }
	
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName()); 	// create a new entry in the report.
		test.log(Status.SKIP, "Test skipped is: "+result.getName());	 	// update status p/f/s.
		
	  }
	
	public void onFinish(ITestContext context) {
		//also write code to send email report.
	    extent.flush();	// Writes test information from the started reporters to their output view.
	    
	  }
	
	
	
}
