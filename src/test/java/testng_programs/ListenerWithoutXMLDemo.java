package testng_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Mostly XML method is used in this. Because the problem is there are multiple test cases and we have just one listener class for all test classes.

//Without  xml, we have to add the annotation in every class to trigger listeners in each test case. Ex: If we have 100 test cases, we have to add annotation in all 100 test cases.
// Thus with XML apprroach is simple.

// Why only 1 listener?? because post actions can be same for many test cases. Like Report generation, screen shot save on failure are some post actions.

@Listeners(testng_programs.MyListeners.class)
public class ListenerWithoutXMLDemo {

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
