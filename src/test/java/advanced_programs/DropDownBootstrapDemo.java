package advanced_programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownBootstrapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//select single option from DD.
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); //opens DD options.
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//capture all the options and then find size.
		List<WebElement> drpList = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println(drpList.size());
		
		//print all the options selected.
		System.out.print("List of values in the dropdow are : ");
		for(WebElement wb : drpList) {
			System.out.print(wb.getText() + " " );
		}
		
		//select multiple options.
		for(WebElement wbb: drpList) {
			if(wbb.getText().equals("C#") || wbb.getText().equals("Python")) {
				wbb.click();
			}
		}
	}

}
