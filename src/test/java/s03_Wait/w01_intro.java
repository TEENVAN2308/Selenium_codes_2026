package s03_Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class w01_intro {
	WebDriver driver;
	
	
	
	
  @Test
  public void f()  throws InterruptedException{
	  //wait commands
	  //Thread.sleep
	  Thread.sleep(5000);
	  System.out.println("Hi i am using Thread.sleep");
	  //implicit wait -- 5 second wait krna nhi to we are done! Pr agr 5 seconds se pehele aagya tw don't wait till 5
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  System.out.println("Hi i am using Implicit wait");
	  //explicit wait -- waiting +conditions
	  WebDriverWait mywait = new WebDriverWait(driver , Duration.ofSeconds(10));
	  WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-2")));
	  System.out.println(element.getText());
	  //fluent wait
	  Wait<WebDriver> mywait02 = new FluentWait<WebDriver>(driver)
			  .withTimeout(Duration.ofSeconds(10))
			  .pollingEvery(Duration.ofSeconds(2))
			  .ignoring(NoSuchElementException.class);
	  element = mywait02.until(new Function<WebDriver,WebElement>(){
		  public WebElement apply(WebDriver driver) {
			  return driver.findElement(By.id("product-2"));
		  }
		  
	  });
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get("https://sauce-demo.myshopify.com");
	  driver.manage().window().maximize();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
