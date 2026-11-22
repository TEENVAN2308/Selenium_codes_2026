package s02_Selectors;

import java.time.Duration;
import java.util.List;
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

public class w05_handleCheckboxes {
	WebDriver driver;
	
	
	
	
	  @Test
	  public void f()  throws InterruptedException{
		 //1 select specific checkbox
		  System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[4]/div[1] ")).getText());
		  //2 select multiple checkbox --> find common element in them -- 
		  List<WebElement> weekday = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		  
		  for(WebElement day : weekday)
		  {
			  day.click();// these will be pointing to checkboxes not to the text they are associated with
			  System.out.println(day.getAttribute("value"));;
		  }
		  
		  
//		  for(int i=0;i<weekday.size();i++)
//		  {
//			  weekday.get(i).click();
//		  }
		  
		  
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new ChromeDriver();
		  driver.get("https://testautomationpractice.blogspot.com/");
		  driver.manage().window().maximize();
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
