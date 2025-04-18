package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// Alert is not webelement. So cannot inspect it. i.e., cannot access attributes for alerts.
		//Alerts and popups are different from Ads.

	// Normal alert with OK button.
	
	  driver.findElement(By.
	  xpath("//button[normalize-space()='Click for JS Alert']")).click();
	  Thread.sleep(5000); 
	  Alert myAlert = driver.switchTo().alert();
	  System.out.println(myAlert.getText()); 
	  myAlert.accept();
	 
		
	//Confirmation Alert with OK and Cancel button.
	
	  driver.findElement(By.
	  xpath("//button[normalize-space()='Click for JS Confirm']")).click();
	  Thread.sleep(2000); 
	  driver.switchTo().alert().dismiss(); //dismiss using cancel button. 
	  driver.switchTo().alert().accept(); // accept using OK button.
	 		
	//Prompt alert with input box.
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Smita");
		driver.switchTo().alert().accept();
		
	
	}

}
