package advanced_programs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrokenLinkDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//Link href="http://www.deadlinkcity.com/" attribute shud be there in page
		//Hit the url to the server and server returns the status code.
		//If status code>=400 then its broken link.  <400 its not a broken link.
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int totNoOfLinks = links.size();
		int numOfBrokenLinks = 0;
		
		for(WebElement wb : links) {
			String hrefAttri = wb.getAttribute("href");
			if(hrefAttri == null || hrefAttri.isEmpty() || hrefAttri.isBlank()) {
				System.out.println("Not possible to verify cz its null or empty.");
				continue;
			}
			
			//hit url to server.
		try {
			URL url = new URL(hrefAttri);
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); //open connection to the server.
			con.connect(); 	//connect to the server and send the request to the server.
			int respCode = con.getResponseCode(); 	//get status code.
			
			if(respCode >= 400) {
				System.out.println("Broken link ====> "+hrefAttri);
				numOfBrokenLinks++;
			}else
				System.out.println("Valid link: "+hrefAttri);
		}catch(Exception e) {
			System.out.println("Excpetion occured: "+e.getMessage());
		}
		}
		System.out.println("Number of broken links are: "+numOfBrokenLinks);
	}

}
