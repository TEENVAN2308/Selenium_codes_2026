/* 
 * Testing for Selecting a dropdown menu right now using Select method in selenium.ui
 * */



package s02_Selectors;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  WebElement Noir_jacket = driver.findElement(By.cssSelector("#product-2 h3"));
	  Noir_jacket.click();
	  WebElement Size = driver.findElement(By.cssSelector("#product-select-option-0"));
	  Select DaSize =new Select(Size);
	  DaSize.selectByVisibleText("M");
	  driver.findElement(By.id("add")).click();
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	  WebElement mini_cart = driver.findElement(By.cssSelector(".cart"));
	  wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id("minicart"),"0")));
	  boolean isPresent = mini_cart.getText().equalsIgnoreCase("My Cart (1)");
	  System.out.println("mini cart text rn : "+mini_cart.getText());
	  System.out.println("Did we add new item in the Cart ? : "+isPresent);
	  }
  @BeforeMethod
  public void beforeMethod()
  {
	  driver = new ChromeDriver();
	  driver.get("https://sauce-demo.myshopify.com/");
	  driver.manage().window().maximize();
	  
  }
  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }
}
