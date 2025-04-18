package advanced_programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerReusableDemo {

	//select future date.
	static void selectFutureDate(WebDriver driver, String year, String month, String date) {
		// TODO Auto-generated method stub
		while (true) {
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (mon.equals(month) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement wb : dateList) {
			if (wb.getText().equals(date)) {
				wb.click();
				break;
			}
		}
	}

	//select past date.
	static void selectPastDate(WebDriver driver, String year, String month, String date) {
		// TODO Auto-generated method stub
		while (true) {
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (mon.equals(month) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement wb : dateList) {
			if (wb.getText().equals(date)) {
				wb.click();
				break;
			}
		}
	}
	
	// select month and year.
	static void selectMonthAndYear(WebDriver driver, String year, String month) {
		while (true) {
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (mon.equals(month) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
	}

	//select date.
	static void selectDate(WebDriver driver, String date) {
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement wb : dateList) {
			if (wb.getText().equals(date)) {
				wb.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// Switch to iframe.
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String year = "2025", month = "January", date = "10";
		
		//selectMonthAndYear(driver, year, month);
		//selectDate(driver, date);
		selectPastDate(driver, year, month, date);
		//selectFutureDate(driver, year, month, date);
	}
}
