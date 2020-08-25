package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class FilterProductList {
	

	private WebDriver driver;
	private String adminURL;
	private LoginPOM loginPOM;
	private static Properties properties;
	
	
  @Test
  public void f() {
  }
  	@BeforeClass
  		public void beforeClass() throws IOException {
	  	properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
  }
  	@BeforeMethod
  	  	public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 
			adminURL = properties.getProperty("adminURL");
			//screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(adminURL);	  
  }
  	@Test
		public void ProductList() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		loginPOM.clickcatalogBtn();
		loginPOM.clickproductBtn();
		loginPOM.sendProductName("Blazer-Boys");
		loginPOM.clickFilterBtn();
		Thread.sleep(1000);
		//screenShot.captureScreenShot("First");
	}
	@AfterMethod
		public void logout() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
