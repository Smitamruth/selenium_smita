package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InneriFrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement fr3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(fr3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Smita");
		
		//now switching to the inner frame - which is a part of frame 3.
		driver.switchTo().frame(0); 	// used when it has only 1 frame to switch to.
		
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		
		
		driver.findElement(By.xpath("//div[@id='i27']//div[@class='uHMk6b fsHoPb']")).click();
		driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']")).click();
		
		driver.switchTo().defaultContent();
		
	}

}
