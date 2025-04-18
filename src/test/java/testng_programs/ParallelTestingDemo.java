package testng_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestingDemo {

	// 1) Create a test case.
	// 2) Create an XML File to run the test case.
	// 3) Passed browser name parameter from xml file and received in setup() method.
	// 4) Execute test case on chrome, edge and firefox. (called as Serial/Sequential Execution)
	// 5) To make the execution parallel, need to add parallel = "tests" in suite tag and parallel = "classes" in tests tag.
	
	//thread-count="5" ==> at runtime it creates multiple threads. 
		//If there are 3 <tests> tags in xml file, the three tests runs sequentially or serially as by default only one thread is created.
		// If thread-count="5" is mentioned then max 5 threads are created so that parallel execution happens.
	// Max thread count can be 2 to 5. Above 5 automatically reduces the speed of execution as it occupies lot of memory.
	
	WebDriver driver;

	@BeforeClass
	@Parameters({"browser", "url"})
	void setup(String br, String url) throws InterruptedException {

		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default : System.out.println("Invalid browser!!"); return; // return is to exit from switch case and 
																	// also rest of the program if the input browser is invalid.
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	void testlogo() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test(priority = 2)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 3)
	void testurl() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterClass
	void teardown() {
		driver.quit();
	}
}
