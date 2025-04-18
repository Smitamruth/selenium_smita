package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadSingleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file upload.
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\ADMIN\\Downloads\\Smita_Resume.pdf");
		
		String fileName = driver.findElement(By.xpath("//ul[@id='fileList']")).getText();
		
		if(fileName.equals("Smita_Resume.pdf")) {
			System.out.println("Upload successful!!");
		}else
			System.out.println("Upload failed!!");
		
	}

}
