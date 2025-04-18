package advanced_programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsIncognitoDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions opt = new ChromeOptions();
		
		//To run the tests in incognito mode.
		opt.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(opt);

		driver.get("https://demo.nopcommerce.com/");

	}

}
