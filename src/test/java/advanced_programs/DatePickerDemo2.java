package advanced_programs;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {

	static void selectDate(WebDriver driver, String reqYear, String reqMonth, String reqDate ) {
		// select year
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selYear = new Select(yearDropDown);
		selYear.selectByVisibleText(reqYear);

		while (true) {
			// select month
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			// convert reqMonth and displayMonth into Month objects.
			Month expectedMonth = convertMonth(reqMonth);
			Month currentMonth = convertMonth(displayMonth);

			// compare months.
			int result = (expectedMonth.compareTo(currentMonth)); // always returns integer(difference in the objects) either 0(equal) or -1(past) or +1(future).
			if (result > 0) {
				// future month
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else if (result < 0) {
				// past month
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} else {
				break;
			}

		}
		
		//select date
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement wb : dateList) {
			if(wb.getText().equals(reqDate)) {
				wb.click();
				break;
			}
		}

	}
	// user defined method for converting month from string --> month.
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();

		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid Month..");
		}
		return vmonth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Switch to frame.
		driver.switchTo().frame("frame-oe796456169");

		String reqYear = "2025", reqMonth = "January", reqDate = "10";

		selectDate(driver, reqYear, reqMonth, reqDate);   
	}
}
