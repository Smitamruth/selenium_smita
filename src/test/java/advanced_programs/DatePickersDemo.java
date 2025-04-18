package advanced_programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickersDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//In an application, once if you write script for date pickers, its reusable for others too within the application.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//Switch to iframe.
		driver.switchTo().frame(0);
		
		//Method 1 -- SendKeys() method.		
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/10/1992");		 // mm/dd/yyyy.
		
		//Method 2 -- Using DatePicker element.
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String year = "2025", month = "September", date = "10";
		
		while(true) {
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			if(mon.equals(month) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//select date
		
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement wb : dateList) {
			if(wb.getText().equals(date)){
				wb.click();
				break;
			}
		}
		
	}

}
