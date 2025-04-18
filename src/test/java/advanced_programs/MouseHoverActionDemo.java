package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActionDemo {
	
	//Mouse Actions - Mouse Hover - moveToElement(WE) || Right click - contextClick(WE) || 
					// Double click - doubleClick(WE) || Drag & Drop - dragAndDrop(source, destination).

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com.gr/");
		driver.manage().window().maximize();
		
		
		WebElement comp = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
		WebElement monitors = driver.findElement(By.xpath("//a[normalize-space()='Monitors (2)']"));
		Actions act = new Actions(driver); // Actions is predefined class provided in selenium.
		act.moveToElement(comp).moveToElement(monitors).click().build().perform();    // build().perform() compulsory ==> 
																			// build() creates an action & perform() completes the action.
																			// directly perform() can be used cz it performs both build and perform.
																			// build() thus is optional to use.
		
		// build()
		//build().perform() --> 
		
	}

}
