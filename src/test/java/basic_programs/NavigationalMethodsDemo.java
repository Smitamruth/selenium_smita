package basic_programs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalMethodsDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		/*
		 * //passing url as url object. URL myUrl = new
		 * URL("https://demo.opencart.com.gr/"); driver.navigate().to(myUrl);
		 */
		// passing url as string object.
		driver.navigate().to("https://demo.opencart.com.gr/");

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());

		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());

		driver.navigate().refresh();
	}

}
