package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopupsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

	// using https://username:password@url , the username & pwd can be passed directly.
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); // this is the only to handle authenticated popups. 
																				// switchTo() won't work and explicitWait won't work.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}

}
