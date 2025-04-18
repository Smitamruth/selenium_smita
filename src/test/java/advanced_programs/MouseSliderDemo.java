package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSliderDemo {

	// Slider - dragAndDropBy(WE, x, y)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

		WebElement leftSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		System.out.println(leftSlider.getLocation()); // (59, 257)

		Actions act = new Actions(driver);

		act.dragAndDropBy(leftSlider, 100, 0).perform();
		System.out.println(leftSlider.getLocation()); // (161, 257)

		WebElement rightSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		System.out.println(rightSlider.getLocation()); // (544, 257)

		
		  act.dragAndDropBy(rightSlider, -100, 0).perform();
		  System.out.println(rightSlider.getLocation()); // (442, 257)
		 	
		}

}
