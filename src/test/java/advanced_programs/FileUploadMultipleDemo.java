package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadMultipleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//multiple files upload.
		String file1 = "C:\\Users\\ADMIN\\Downloads\\Smita_Resume.pdf";
		String file2 = "C:\\Users\\ADMIN\\Downloads\\Resume_Rahul_Gupta_Java.pdf";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2); 	// \n represents new line.
		
		int numOfFiles = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		System.out.println("Number of files uploaded is: "+numOfFiles);
		
	}

}
