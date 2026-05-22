package s02_Selectors;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class w01_SeleniumSelectors
{
	WebDriver driver;
  @Test
  public void SeleniumSelectors() throws InterruptedException 
  {
	  // Launching the application
	  driver.get("https://lkmdemoaut.accenture.com/AccenSportz/#/");
	  // Using  link text to click on Book Tickets
      // clicking on book tickets
	  driver.findElement(By.linkText("Book Tickets")).click(); 
	  // Using partial link text to click on Book Tickets
      driver.findElement(By.partialLinkText("Book")).click();
	  // Using CSS Selector to select India vs Pakistan ticket
	  driver.findElement(By.cssSelector("button[name='ticket'][value='India vs Pakistan']")).click();
	  // Using ID locator to enter name
	  driver.findElement(By.id("name")).sendKeys("Hema");
	  // Using Name locator to enter phone number
	  driver.findElement(By.name("phonenumber")).sendKeys("9391733523");
      // Using ID locator to open quantity dropdown
	  driver.findElement(By.id("mat-select-value-1")).click();
	  driver.findElement(By.name("submitbutton")).click();
	  // Validating confirmation message using ID locator
	  Assert.assertEquals(driver.findElement(By.id("message2")).getText(),"Your tickets for India vs Pakistan match will be sent to you via email.");
	  // Clicking OK button using ID locator
	  driver.findElement(By.id("okbutton")).click();
	  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  // Launching Edge browser
	  driver = new EdgeDriver();
	  // Maximizing browser window
	  driver.manage().window().maximize();
	  // Applying implicit wait
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() 
  {
	// Closing browser
	  driver.quit();
  }

}

