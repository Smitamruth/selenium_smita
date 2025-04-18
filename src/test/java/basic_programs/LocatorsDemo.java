package basic_programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		/* driver.get("https://demo.opencart.com.gr/"); */
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// Locate by Id.
		/*
		 * boolean logoDisplay = driver.findElement(By.id("logo")).isDisplayed();
		 * if(logoDisplay) { System.out.println("Logo is displayed."); }
		 */

		// Locate by Name.
		/* driver.findElement(By.name("search")).sendKeys("Android"); */

		// Locate by LinkText.
		/* driver.findElement(By.linkText("Desktops")).click(); */

		// Locate by Partial Link Text.
		/* driver.findElement(By.partialLinkText("lets")).click(); */

		// Locate by TagName.
		/*
		 * List<WebElement> buttonLinks = driver.findElements(By.tagName("button"));
		 * System.out.println("Size of List of Button liks is: "+buttonLinks.size());
		 */

		// Locate by ClassName.
		/*
		 * List<WebElement> dropDownList =
		 * driver.findElements(By.className("dropdown"));
		 * System.out.println("Size of List of Dropdown liks is: "+dropDownList.size());
		 */

//From here use demo.nopcommerce.com
		// Locate by CSS Selector.
			// tag#id
		/*
		 * driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys(
		 * "t-shirts");
		 */

			// tag.classname ((Dont forget to put .before className)) && ((don't put
		// className with spaces))
		/* driver.findElement(By.cssSelector(".search-box-text")).sendKeys("denims"); */
			
			// tag[attribute = value]
			/*
			 * driver.findElement(By.cssSelector("[placeholder=\"Search store\"]")).sendKeys
			 * ("sarees");
			 */
		
			//tag.classname[attribute = value]
			/*
			 * driver.findElement(By.
			 * cssSelector(".search-box-text[placeholder=\"Search store\"]")).sendKeys(
			 * "Jumpsuits");
			 */
		
		
		//Locate by Xpath
			// xpath with single attribute
		/*
		 * driver.findElement(By.xpath("//input[@placeholder=\"Search store\"]")).
		 * sendKeys("Tops");
		 */
		
			// xpath with multiple attributes
			/*
			 * driver.findElement(By.
			 * xpath("//input[@name='q'][@placeholder=\"Search store\"]")).
			 * sendKeys("Coord sets");
			 */
		
			// xpath with and or operators
			/*
			 * driver.findElement(By.
			 * xpath("//input[@name='q' and @placeholder=\"Search store\"]")).sendKeys(
			 * "Salwars");
			 */
		
			//xpath with inner texts - text()
			/* driver.findElement(By.xpath("//a[text()='Wishlist']")).click(); */
		
			// xpath using contains().
			/*
			 * driver.findElement(By.xpath("//input[contains(@placeholder, 'Sea')]")).
			 * sendKeys("Kurta Sets");
			 */
		
		// xpath using starts-with()
		driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]")).sendKeys("Kurta Sets");
		
		// driver.close();
	}

}
