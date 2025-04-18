package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDynamicWithagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//capturing text "Showing 1 to 10 of 21153 (2116 Pages)".
		String s = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		s.substring(s.indexOf("(") + 1, s.indexOf("Pages") - 1);
		int total_pages = Integer.parseInt(s);
		
		//Repeating pages 
		for(int i =0; i<total_pages; i++) {
			
			if(i>1) {
				WebElement active_pg = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + i +"']"));  //to click on next page
				active_pg.click();
			}

			//reading data from page
			int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
			
			for(int x=1; x<=rows;x++) {
				for(int y =2; y<=4; y++) {
					String values = driver.findElement(By.xpath("//table//tbody//tr["+x+"]//td["+y+"]")).getText();
					System.out.print(values + "\t");
				}
				System.out.println();
				}
			}
					
		}
		
		
	}

