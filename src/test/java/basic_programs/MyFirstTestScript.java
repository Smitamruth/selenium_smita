package basic_programs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class MyFirstTestScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		System.out.println("The title of the page is: "+driver.getTitle()); 
		if (driver.getTitle().contains("OpenCart")) {
			System.out.println("Test passed!!");
		}else
			System.out.println("Test failed!!");
		driver.close();
	}

}
