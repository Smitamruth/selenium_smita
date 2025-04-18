package testng_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*1) Open App
2) Test logo presence
3) Login
4) Close*/

public class OrangeHRM {

	WebDriver driver;

	@Test(priority = 1)
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	void testLogo() throws InterruptedException {
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed()) {
			System.out.println("Logo displayed!!");
		} else
			System.out.println("No logo present.");
	}

	@Test(priority = 3)
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 4)
	void closeApp() {
		driver.close();
	}

}
