package s02_Selectors;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
public class w01_SeleniumSelectors
{
	WebDriver driver;
  @Test
  public void SeleniumSelectors() throws InterruptedException 
  {
	 WebElement login = driver.findElement(By.id("customer_login_link"));
	 System.out.println("Text in login button "+login.getText());
//	 WebElement search = driver.findElement(By.className("search"));
//	 search.sendKeys("Navneet");
//	 search.click();
	 WebElement logo = driver.findElement(By.id("logo"));
	 boolean res= logo.isDisplayed();
	 System.out.println("Is logo displayed :"+res);
	 WebElement link = driver.findElement(By.linkText("Shopping Cart by Shopify"));
	 link.click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 File srcFile = link.getScreenshotAs(OutputType.FILE);
//	 System.out.println("Absolute path : "+srcFile.getAbsolutePath());
	 List<WebElement> navigation_links = driver.findElements(By.cssSelector(".accordion a"));
	 for(WebElement listss : navigation_links)
	 {
		 System.out.println(listss.getText());
	 }
	 
	 
	 
	  // Using  link text to click on Book Tickets
      // clicking on book tickets
//	  driver.findElement(By.linkText("My Cart ")).click(); 
//	  WebElement My_cart = driver.findElement(By.linkText("My Cart "));
//	  System.out.println("My_cart : "+ My_cart);
	  // Using partial link text to click on Book Tickets
//      driver.findElement(By.partialLinkText("Book")).click();
//	  // Using CSS Selector to select India vs Pakistan ticket
//	  driver.findElement(By.cssSelector("button[name='ticket'][value='India vs Pakistan']")).click();
//	  // Using ID locator to enter name
//	  driver.findElement(By.id("name")).sendKeys("Hema");
//	  // Using Name locator to enter phone number
//	  driver.findElement(By.name("phonenumber")).sendKeys("9391733523");
//      // Using ID locator to open quantity dropdown
//	  driver.findElement(By.id("mat-select-value-1")).click();
//	  driver.findElement(By.name("submitbutton")).click();
//	  // Validating confirmation message using ID locator
//	  Assert.assertEquals(driver.findElement(By.id("message2")).getText(),"Your tickets for India vs Pakistan match will be sent to you via email.");
//	  // Clicking OK button using ID locator
//	  driver.findElement(By.id("okbutton")).click();
	  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  // Launching Edge browser
//	  driver = new EdgeDriver();
	   
	  
	  driver = new ChromeDriver();
	  
	  // Maximizing browser window
	  driver.manage().window().maximize();

	  // Launching the application
	  driver.get("https://sauce-demo.myshopify.com/");
	  // Applying implicit wait
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
  }

  @AfterMethod
  public void afterMethod() 
  {
	// Closing browser
	  driver.quit();
  }

}

