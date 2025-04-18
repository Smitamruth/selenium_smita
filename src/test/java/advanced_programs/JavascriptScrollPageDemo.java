package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptScrollPageDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Scroll bar - is not part of web elements. Its out of the box.
		
		//Method1 - scroll till the mentioned pixel.
		/*
		 * js.executeScript("window.scrollBy(0, 2000)", "");
		 * System.out.println(js.executeScript("return window.pageYOffset;"));
		 */
		
		//Method2 - scroll till the element is visible.
		/*
		 * WebElement word =
		 * driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		 * js.executeScript("arguments[0].scrollIntoView();", word); //arguments[0] is
		 * used to capture the element.
		 * System.out.println(js.executeScript("return window.pageYOffset;"));
		 */
		
		//Method3 - scroll till the end of the page.
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");	
		System.out.println(js.executeScript("return window.pageYOffset;"));
	
		//go back to initial position.
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");	
		System.out.println(js.executeScript("return window.pageYOffset;"));
	
	}

}
