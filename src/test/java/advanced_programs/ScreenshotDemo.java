package advanced_programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// After selenium 4 onwards, webelement methods are provided to take screenshot of specific webelement or specific section.
		
		
		//Method 1 - Full Page Screenshot.
		TakesScreenshot ts = (TakesScreenshot)driver; 	// driver child is assiged to TakesScreenshot parent.
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // calling method from TakeScreenshot interface 
																//somewhere in the memory, the screenshot is taken. Don't know where exactly.
		
			//File targetFile = new File("C:\\Users\\ADMIN\\eclipse-workspace\\screenshot\\fullPage.png");	// hardcoded path.
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshot\\fullPage.png");
		sourceFile.renameTo(targetFile); 	// copy sourceFile to targetFile.
		
		//Method 2 - Specific area screenshot.
		WebElement feature = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File specSrcFile = feature.getScreenshotAs(OutputType.FILE); // calling method from Webelement interface ==> 
																		// which is a child interface of SearchConntext interface..
		
		File targtFile = new File(System.getProperty("user.dir")+"\\screenshot\\specificPage.png");
		specSrcFile.renameTo(targtFile);
		
		
		//Method 3 - specific web element like logo or image.
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File logoFile = logo.getScreenshotAs(OutputType.FILE);
		File tarFile = new File(System.getProperty("user.dir")+"\\screenshot\\logo.png");
		logoFile.renameTo(tarFile);
		
		
		
	}

}
