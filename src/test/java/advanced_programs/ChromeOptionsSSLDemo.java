package advanced_programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsSSLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SSL Handling - Secure Socket Layer - Kind of certificate used to browse some websites.
		
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true); 		//by default its false, make it true.
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle()); // privacy error.
		
		
		
	}

}
