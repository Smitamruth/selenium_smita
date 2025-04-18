package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFramesDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//iframe -- webpages (with separate urls) embbeded into another webpage. || 
					// Driver instance is passed by id, name or entire frame. || 
					// cannot directly switch from one frame to another.
		//frame -- grouping of elementss into separate section.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	// 3 different ways to switch to iframes.
		//1) FRAME passed using WEBELEMENT instance.
		WebElement fr1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(fr1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Smita");
		driver.switchTo().defaultContent(); // switches back to main page
		
		
		WebElement fr2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(fr2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Amruth");
		driver.switchTo().defaultContent();
		
	}

}
