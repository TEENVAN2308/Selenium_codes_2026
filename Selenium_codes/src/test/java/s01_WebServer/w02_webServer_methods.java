package s01_WebServer;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class w02_webServer_methods {
	WebDriver driver;

	@Test
	public void f() {
		// getTitle -> will provide us with the title of the project.
		// getCurrentUrl -> it will provide us with the url of the website
		String title = driver.getTitle();
	    String url = driver.getCurrentUrl();
	    System.out.println("Page Title: " + title + " | URL: " + url);	
		
		
		
		// close -> automatically close the webDriver after the test is executed.
	    //	 	 -> It will only close the current window.
	    // quit -> to close all windows and ends session.
		driver.close();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.get("https://lkmdemoaut.accenture.com/AccenSportz/#/");

	}

}
