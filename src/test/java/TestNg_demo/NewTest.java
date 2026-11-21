package TestNg_demo;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	
    @BeforeMethod
	void login()
	{
		System.out.println("this is login");
	}
	@Test(priority =1)
	void search()
	{
		System.out.println("this is search");
	}
	@Test(priority =2)
	void advancesearch()
	{
		System.out.println("advanced search");
	}
	@AfterMethod
	void logout() {
		System.out.println("this is logout");
	}
	

}
