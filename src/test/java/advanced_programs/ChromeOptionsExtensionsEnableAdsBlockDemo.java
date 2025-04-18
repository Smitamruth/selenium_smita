package advanced_programs;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExtensionsEnableAdsBlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions opt = new ChromeOptions();

		// To block ads. // To enable plug-ins & extensions in automation browsers too.
		//Step 1 - Add CRX Extractor or Downloader to Chrome browser(manually).  ==> to extract crx file of any other extensions.
		
		//Step 2 - Add SelectorsHub plugin to Chrome browser(manually).  
		
		//Step 3 - Capture CRX File for SelectorsHub extension.		==> to make it available in runtime.  
																		//Right click on selector hub in google chrome store and click on download crx file.
		
		//Step 4 - Pass CRX File path in automation script in Chrome Options.
		File fl = new File("C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		opt.addExtensions(fl);

		WebDriver driver = new ChromeDriver(opt);

		driver.get("https://text-compare.com/");

	}

}
