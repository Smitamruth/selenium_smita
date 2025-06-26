package testng_programs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListenersDemo {

//Based on the execution status(passed or failed or skipped), certain actions are taken which are called Post Actions.	
	// These post actions are performed using Listeners.
	// ITestListener Class is a predefined interface(which has default methods) from which we implemented in our Listener Class.
		// or can also extend TestListenerAdapter class to trigger same listeners.
	
	//TestListenerAdapter class already has implemented ITestListener methods. Therefore when you extend TestListenerAdapter 
		//in your listener class, te implementation may not be suitable for our projects. SO need to override them.
		
	
	// Create xml file to run the test case. Inside this xml file, mention the listener class ==> makes the automatic trigger of listeners.
	
	
		// 1) Create a test case.
		// 2) Create a listener class.
		// 3) Create an xml file and include both test case and listener class.
		
	// Only 1 listener is created for many classes.
	
	//Listener class can also be triggered w/o using xml file. ==> Add @Listeners Annotation before start of class.
	
	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException {

		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	void testlogo() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test(priority = 3, dependsOnMethods = {"testurl"})
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 2)
	void testurl() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/logi");
	}

	@AfterClass
	void teardown() {
		driver.quit();
	}
}

	
	
	
	
