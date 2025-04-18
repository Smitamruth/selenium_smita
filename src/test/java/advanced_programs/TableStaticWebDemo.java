package advanced_programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableStaticWebDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
	//Web Tables 
		// 1) Static Web Table.
		// 2) Dynamic Web Table.
		// 3) Pagination Table.
		
		
		//Static Table - 
		
		//Number of rows in a table.
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows = " + rows);
		
		//Number of columns in a table.
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		//Read data from specific row and column.(Ex: 5th row and 1st column)
		String specific = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Data from specific row and column is: "+specific);
		
		//read data from all rows and columns.
		System.out.print("Book Name" + "\t" + "Author" + "\t" +"Subject" +"\t" +"Price");
		for(int i=2; i<rows; i++) {
			for(int j=1; j<cols; j++) {
				String values = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td["+ j +"]")).getText();
				System.out.print(values + "\t");
			}
			System.out.println();
		}
		
		//print book names whose author name is Mukesh.
		
		for(int r=2; r<rows;r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(author.equalsIgnoreCase("Mukesh")) {
				System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r +"]//td[1]")).getText() +"\t" +author);
			}
		}
		
		//sum of prices of all books.
		int total =0;
		for(int r=2; r<=rows;r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
		total = total + Integer.parseInt(price);
		}
		System.out.println("Price of all books is : "+total);
	}

}
