package s01_WebServer;

import org.testng.annotations.Test;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class w01_Initializing_webDriver {
  @Test
  public void f() {
	 
	  // Launching Edge browser . U need different method for different browser.
	  WebDriver  driver = new EdgeDriver();
	  
	  //opening the url 
	  driver.get("https://sauce-demo.myshopify.com/"); 
	  String actual_title = driver.getTitle();
	  System.out.println("the title is : "+actual_title);
	  // Maximizing browser window
	  driver.manage().window().maximize();
	  
	  // Applying implicit wait
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.close();
  }
}
