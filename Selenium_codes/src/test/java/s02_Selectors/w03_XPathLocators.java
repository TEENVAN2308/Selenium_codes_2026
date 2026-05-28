package s02_Selectors;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;	

public class w03_XPathLocators {
	WebDriver driver ;
	
  @Test
  public void f() {
	  //Relative XPath with multiple attribute
	  driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Tshrits");
	  //using with 'and' operator
	  driver.findElement(By.xpath("//input[@name='q'and @placeholder='Search store']")).sendKeys("Tshirts");
	  //using with 'or' operator
	  driver.findElement(By.xpath("//input[@name='search'or @placeholder='Search']")).sendKeys("Tshirts");
	  //Xpaht with inner text - text()
	  driver.findElement(By.xpath("//*[text()='Search']")).click();
	// XPath using contains()
	  driver.findElement(By.xpath("//input[contains(@id,'search')]"));
	  // XPath using starts-with()
	  driver.findElement(By.xpath("//input[starts-with(@id,'small')]"));
	  // XPath using following-sibling
	  driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input"));
	  // XPath using parent
	  driver.findElement(By.xpath("//input[@id='email']/parent::div"));
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new EdgeDriver();
	  driver.get("https://demo.nopcommerce.com/");
	  driver.manage().window().maximize();
  }

}
