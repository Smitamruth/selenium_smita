package advanced_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingShadowDOMDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// DOM - Document Object Model - created when we're browsing on a web page using
		// internet.
		// DOM - is created a runtime.

		// Shadow DOM - DOM containing another DOM is called Shadow DOM.
		// xpath doesnot work in SHadow dom. Using CSS element we are capturing element.

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.manage().window().maximize();
		
		//shadow host contains shadow root. Shadow Root contains Shadow DOM elements.
		//first extract shadow host. From this extract inner shadow host. From this. extract inner shadow host.
		
		//1)when the element is inside single shadow DOM.
		
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#shadow-element"));
		
		//2) nested shadow element.
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("#inner-shadow-element"));
		
		//3) multi nested shadow dom.
		SearchContext shadowOne= driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadowTwo = shadowOne.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadowThree = shadowTwo.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadowThree.findElement(By.cssSelector("#multi-nested-shadow-element"));
	}

}
