package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://text-compare.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Hello Smita!! How are you??");
		
		Actions act = new Actions(driver);
		
		//Ctrl+A -- Select the text.
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform(); // Keys down when we press Ctrl on Keyboard and then send A as key
																				// Then release the pressed key and perform the action to complete.
		
		//Ctrl+C -- Copies the text.
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform(); // Keys down when we press Ctrl on Keyboard and then send C as key.
																				// Then release the pressed key and perform the action to complete.
		
		//Ctrl+Tab -- Move to the 2nnd box.
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
				
		//Ctrl+V -- Paste the text.
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform(); // Keys down when we press Ctrl on Keyboard and then send V as key.
																				// Then release the pressed key and perform the action to complete.
		
		//to press Ctrl+Shift+A
		act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();  	
														// whichever key is performed last is released first. #####LIFO
	}

}
