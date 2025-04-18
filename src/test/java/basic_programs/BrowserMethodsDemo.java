package basic_programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		Set<String> windowIDs = driver.getWindowHandles();

		/*
		 * //Approach1 
		 * List<String> windowList = new ArrayList(windowIDs);
		 * 
		 * String parentID = windowList.get(0); 
		 * String childID = windowList.get(1);
		 * 
		 * driver.switchTo().window(childID); 
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().window(parentID); 
		 * System.out.println(driver.getTitle());
		 */

		//Approach2
		for(String str : windowIDs) {
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());
		}
	}

}
