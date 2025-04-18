package advanced_programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDisableMessageDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions opt = new ChromeOptions();
		
		//To remove "Chrome is being controlled by automated test software".
		opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} );
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://demo.nopcommerce.com/");
		
		
		
		
		
	}

}
