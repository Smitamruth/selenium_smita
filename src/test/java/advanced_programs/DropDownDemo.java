package advanced_programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	// select dd || bootstrap dd || hidden dd.
		
		//1) Select DD - can be handled using Select class.
		WebElement drpdwn = driver.findElement(By.xpath("//select[@id='country']"));
		Select sc = new Select(drpdwn);
		
	//	sc.selectByVisibleText("India");
	//	sc.selectByValue("japan");
		sc.selectByIndex(4); 		//index starts from 0.
		
		
	//capture the options from the dd.
		List<WebElement> drpList = sc.getOptions();   // getOptions is a method particular to Select class 
														// => returns all the options as webelement.
		
		System.out.println(drpList.size());
		System.out.print("List of countries in the DropDown are : ");
		for(WebElement wb : drpList) {
			System.out.print(wb.getText() + " ");
		}
	
	}

}
