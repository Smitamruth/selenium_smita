package testng_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Parameterization - achieved by using 
// 1) Data Providers(used for Data driven testing) and 
// 2) Using xml file parameters are passed(called as Parallel Testing).

// 1)Data provider -- is basically a method which will create some data and pass into another test methods.
		// @DataProvider class creates some data and provides data to @Test class which tests the application.
		// Avoids loop statement. // Depending on the number of times the data is provided to @test class, that many times it runs.
// 2)XML based --  XML file ==> Automation script (used loop statement to read data from XML) ==> Application under test.

// We will have an excel file which will have data. Data provider method itself will have the logic which will read the data and keeps data in 2D array.

// Earlier we read the excel file and each time loop starts and hits and tests the application. 
// But using Data Provider class, we get all the data in 2D array and run the application taking each data. Test method will run multiple times based on the number of inputs. 

// Data Provider is a method through which we pass the test data to another test method. || No indexing required. || No looping required. || DP itself takes care of that. 
		// @DataProvider Method ==> @Test Method. 


// Web Testing - data is read mostly from excel files or property files.
// API Testing - data is read from JSON file.

public class DataProviderDemo {

	WebDriver driver;

	@BeforeClass
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider="dp")
	void testLogin(String email, String pwd) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(5000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(status);
		}else
			Assert.fail();
	}

	@AfterClass
	void tearDown() {
		
		driver.close();
	}

	@DataProvider(name = "dp", indices = {0, 1 })			//Purpose is to creating and providing data.
	Object[][] loginData() {   
		
		Object data[][] = {
				{"smita.sa1023@gmail.com", "test@123"},
				{"abc@gmail.com", "test@123"},
				{"pavanol123@gmail.com", "test@123"}
				};
		
		return data;
	}
}
