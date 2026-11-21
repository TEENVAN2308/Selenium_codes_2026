package com.revision;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import static java.lang.Thread.*;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest  {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  //use explicit wait 
	  WebDriverWait Nwait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  WebElement noirJac = Nwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-2")));
	  System.out.println("The text inside the product=2 is : "+noirJac.getText());
	  noirJac.click();
	  WebElement Selected_color = driver.findElement(By.id("product-select-option-1"));
	  Select Color = new Select(Selected_color); 
	  Color.selectByContainsVisibleText("Red");
	  
	  driver.findElement(By.xpath("//input[@id = 'add']")).click();
	  WebDriverWait mycart_wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  Boolean what = mycart_wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cart-target-desktop"),"1"));
	  WebElement minicart =  driver.findElement(By.xpath("//*[@id=\"minicart\"]/a[1]"));
	  System.out.println(minicart.getText());
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals("false", what);
	  
	  minicart.click();
	  
	  Thread.sleep(5000);
	  
	  sa.assertAll();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  //initializing a new webdriver->helpoing us to automate browsers.
	  driver =new ChromeDriver();
	  //getting the url first
	  driver.get("https://sauce-demo.myshopify.com/");
	  //just maximising the window for better result;
	  driver.manage().window().maximize();
	  
	  //using implicit wait for every element
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
