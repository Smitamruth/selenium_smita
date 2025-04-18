package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardActionsNewWindowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);  // switches to new tab. // introduced in selenium 4 onwards.
		
		driver.switchTo().newWindow(WindowType.WINDOW);  // // switches to new window. // introduced in selenium 4 onwards.
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		
	}

}
