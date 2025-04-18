package basic_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * 1) get methods ==> Accessed through webdriver instances.
		 * 
		 * get(url) - opens url on browser || getTitle() - returns page title ||
		 * getCurrentUrl() - returns page url || getPageSource() - returns source code
		 * of page || getWindowhandle() - returns ID of single browser window ||
		 * getWindowHandles() - returns ID of multiple browser windows.
		 * 
		 * 2)conditional methods ==> Access commands through WebElement. Returns boolean
		 * value. isDisplayed() - checks display status || isEnabled() - enable/disable
		 * status of element || isSelected() - check selected or not (for checkbox &
		 * radio & dropdown) .
		 * 
		 * 3) Browser methods ==>
		 * 
		 * close() - closes single browser || quit() - closes multiple browsers at a
		 * time.
		 * 
		 * 4) Navigational methods ==> navigate().to() -- functional wise same as
		 * driver.get() but inside to(), its internally calling get(). Difference is in
		 * get() - url is passed as string but in to(), its passed as string or url
		 * locator. Inside get method, it checks if url has come in string format or url
		 * object format. If string format, it redirects or if its object format, it
		 * converts it to string first.
		 * 
		 * 
		 * navigate().forward() || navigate().back() || navigate().refresh() - reloading the page.
		 * 
		 * 5) Wait methods ==> to solve synchronisation problem that occurs due to
		 * mismatch in speed of program execution and the speed of application running
		 * or its response. Due to this, 2 tpes of exception occurs --
		 * NoSuchElementException => locator is correct but sync problem &&
		 * ElementNotFoundException => when locator is not correct.
		 * 
		 * Implicit wait -- written once/one stmt + will not wait max time available +
		 * applicable for whole program once written.
		 * 
		 * Explicit or Fluent wait -- declaration & used specific to web page --
		 * condition based + finding element is inclusive + it waits for condition to be
		 * true and then considers time + need to write multiple stmts for multiple
		 * elements.
		 * 
		 * Fluent wait -- has total timeout of 30s and keeps polling every 5s to check
		 * if the element is available. Also it ignores NoSuchElementException.
		 * 
		 * Thread.sleep(5000) -- is Java provided.
		 * 
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000); // to avoid NoSuchElementException //Java provided - not webdriver method.
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

}
