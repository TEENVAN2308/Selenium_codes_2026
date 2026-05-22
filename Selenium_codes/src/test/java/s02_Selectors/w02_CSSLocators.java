/* 
 * this one is for the CSS selector
 * we use get those CSS properties via CSS selectors 
 * Use their tagname and particular attribute's name or other combos
 * 
 */
package s02_Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class w02_CSSLocators {
	WebDriver driver ;
	@Test
  public void f() {
		// using tag + id
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("HIII");

		// using class + attribute
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shirts");


		// ---------------- OTHER CSS LOCATORS ----------------


		// using only id
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Shoes");

		// using only class
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Mobiles");

		// using tag + class
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Laptop");

		// using tag + attribute
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Watch");

		// using multiple attributes
		driver.findElement(By.cssSelector("input[name='q'][type='text']")).sendKeys("Books");

		// using contains (^ = starts with)
		driver.findElement(By.cssSelector("input[id^='small']")).sendKeys("Start");

		// using contains ($ = ends with)
		driver.findElement(By.cssSelector("input[id$='terms']")).sendKeys("End");

		// using contains (* = contains text)
		driver.findElement(By.cssSelector("input[id*='search']")).sendKeys("Contains");

		// using parent child relation
		driver.findElement(By.cssSelector("div.search-box input")).sendKeys("Keyboard");

		// direct child
		driver.findElement(By.cssSelector("div.search-box > input")).sendKeys("Mouse");

		// nth child
		driver.findElement(By.cssSelector("ul li:nth-child(2)")).click();

		// first child
		driver.findElement(By.cssSelector("ul li:first-child")).click();

		// last child
		driver.findElement(By.cssSelector("ul li:last-child")).click();
		
  }
  @BeforeMethod
  public void beforeMethod() {
	 driver = new ChromeDriver();
	 driver.get("https://demo.nopcommerce.com/");
	 driver.manage().window().maximize(); //maximise the browser windows so that we can see all elements
	 
	 
  }

}
