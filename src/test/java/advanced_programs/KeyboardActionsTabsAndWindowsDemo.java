package advanced_programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsTabsAndWindowsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).click(regLink).keyDown(Keys.CONTROL).perform(); // open the registration page in new tab.
		
		//switching to registration page.
		Set<String> ids = driver.getWindowHandles();
		
		List<String> winList = new ArrayList<String>(ids);  // combine both set and list and can be written as 
															// List<String> winList = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Smita");
		
		//switch to Home Page.
		driver.switchTo().window(winList.get(0));
		
	}

}
