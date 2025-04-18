package advanced_programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		// select specific checkbox.
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//select all the checkboxes.
		List<WebElement> checkList = driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
		
		/*
		 * for(int i=0; i<checkList.size(); i++) { checkList.get(i).click(); }
		 */
		
		/*for(WebElement chkbx : checkList) {
			chkbx.click(); */
			
	//select last 3 checkboxes.
	/*
	 * for(int i = checkList.size()-1; i>=4; i--) { checkList.get(i).click(); }
	 */
			
	//unselect checkboxes
		
		for(int i = 0; i<4; i++) {
			checkList.get(i).click();
		}
		for(int j = 0; j<checkList.size()-1; j++) {
		if(checkList.get(j).isSelected()) {
			checkList.get(j).click();
		}
		}
	}
}


