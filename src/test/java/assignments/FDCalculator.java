package assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelUtils;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='No thanks']")).click();
		
		String filePath = System.getProperty("user.dir") + "\\testdata\\simple.xlsx";
		
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for( int i = 1; i <= rows ; i++) {
			//read data from excel.
			String principal = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String roi = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String time = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String period = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//pass above data to website.
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(time);
			
			Select sel = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			sel.deselectByVisibleText(period);
			
			Select selFreq = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			selFreq.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			String matValue = driver.findElement(By.xpath("//span[@name='resp_matval']//strong")).getText();
			
			//validation.
			if(Double.parseDouble(expValue) == Double.parseDouble(matValue)) {
				System.out.println("Test passed!!");
				ExcelUtils.putCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}else {
				System.out.println("Test failed!!");
				ExcelUtils.putCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//img[@class='PL5']")).clear();
		}
		driver.quit();
		
	}

}
