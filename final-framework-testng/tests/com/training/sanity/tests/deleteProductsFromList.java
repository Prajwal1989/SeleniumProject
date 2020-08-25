package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.deletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class deleteProductsFromList {
	

	private WebDriver driver;
	private String adminURL;
	private deletePOM DeletePOM;
	private LoginPOM loginPOM;
	private static Properties properties;
	
	
	
  
  	@BeforeClass
  		public void beforeClass() throws IOException {
	  	properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
  }
  	@BeforeMethod
  	  	public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			DeletePOM = new deletePOM(driver); 
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
		DeletePOM.clickcatalogBtn();
		DeletePOM.clickproductBtn();
		DeletePOM.sendProductName("Blazer Girls(II-V)");
		DeletePOM.clickFilterBtn();
		DeletePOM.clickselectBox();
		DeletePOM.clickdeleteBtn();	
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
  
			//screenShot.captureScreenShot("First");


	}
  	
	
}
