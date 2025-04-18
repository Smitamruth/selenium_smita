package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//switch to iframe.
		driver.switchTo().frame("iframeResult");
		
		WebElement fld1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement fld2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		fld1.clear();
		fld1.sendKeys("Hi Smita");
		
	
		Actions act = new Actions(driver);
		act.doubleClick(button).build().perform();
		
		System.out.println(fld2.getAttribute("value")); // getText() doesnt work as Hi SMita is not Inner text. 
											// Only value attribute is present as at runtime,
											// javascript function is called and its copied on double click.

		if(fld2.getAttribute("value").equalsIgnoreCase("Hi Smita")) {
			System.out.println("Successfully copied");
		}else
			System.out.println("Not copied properly");
	}
	
	
	//getText() vs getAttribute("attribute") ==> getText returns inner text and getAttribute returns value of the attribute.
	// Ex: <input id="xyz"> welcome </input> ==> here inner text is Welcome. 
												// Therefore getText() gives output --> Welcome. 
												// getAttribute("id") gives output --> xyz.
	// Ex: <input value="welcome'></input> ==> here no inner text.
												// Thus getText() gives null output.
												// getAttribute("value") gives output --> Welcome.

}
