package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.AllArguments;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		//JavascriptExecutor -- is an interface -- has method executeScript() -- can execute JS stmts.
		// click() - when called internally executes javascript stmts which inturn interacts with web elements.
		// its always javascript stmts that are needed to interact with web elements.
		// when click() method cannot execute javascript stmts, it will throw exception called ElementInterceptedException.
		// As a workaround, instead of executing javascript stmts through click(), we can directly execute jS stmts in our WedDriver.
		// not every method, but some action methods like click(), sendKeys() etc.. but not getText(0, getAttribute(), clear() etc..
	
	//workaround using JS for sendKeys().
		WebElement wb = driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','Smita')", wb); 		//arguments[0].setAttribute('value','Smita') ==> 
																					// like getAttribute captures the value present in value attribute,
																					// setAttribute puts the value in value attribute.
		js.executeScript("arguments[0].style.border = '3px solid red'", wb);	// make border red..
		
	//workaround using JS for click().
		WebElement radio = driver.findElement(By.xpath("//input[@id='female']"));
		js.executeScript("arguments[0].click()", radio);							// arguments[0].click() ==> click(0 is JS method performed directly 
																					// on webelement.
		
	}

}
