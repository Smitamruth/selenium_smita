package hybrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) throws MalformedURLException {

		String hubUrl = "http://localhost:4444/wd/hub";
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setPlatform(Platform.WIN11);
		cap.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), cap);
		
		driver.get("httpps://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

}
