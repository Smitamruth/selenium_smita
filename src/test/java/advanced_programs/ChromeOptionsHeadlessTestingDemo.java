package advanced_programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsHeadlessTestingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Headless Testing -- tests running in background without any actions seen on UI. Ex: jenkins is headless testing. Mostly preferred in devops envt.		
		// Advantages -- can do multiple tasks || faster execution.
		//Disadv -- user cannot see the functionality or flow of the test.
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless=new");		// setting for headless mode of execution.
		
		WebDriver driver = new ChromeDriver(co); // if co object is not passed while creating driver instance, the headless wont occur.
		
		driver.get("https://demo.opencart.com.gr/");
		
		String title = driver.getTitle();
		
		if(title.equals("Your Store")) {
			System.out.println("Test passed");
		}else
			System.out.println("Test failed");
		
		driver.quit();
	}

}
