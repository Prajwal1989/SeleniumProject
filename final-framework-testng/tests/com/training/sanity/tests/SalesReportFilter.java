package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.SalesreportPOM;
import com.training.pom.deletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SalesReportFilter {
	

	private WebDriver driver;
	private String adminURL;
	private LoginPOM loginPOM;
	private deletePOM DeletePOM;
	private SalesreportPOM salesreportPOM;
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
			loginPOM = new LoginPOM(driver);
			DeletePOM = new deletePOM(driver); 
			salesreportPOM = new SalesreportPOM(driver);
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
		salesreportPOM.clicksalesIcon();
		salesreportPOM.clicksalesLink();
		salesreportPOM.clickOrderLink();
		DeletePOM.clickFilterBtn();
	//Program to select group by drop down
		salesreportPOM.clickGrpBy();
		WebElement group=driver.findElement(By.id("input-group"));
		Select sel=new Select(group);
		sel.selectByVisibleText("Days"); //Years , Months , Weeks , Days.
	//Program to select order status drop down
		salesreportPOM.clickOrderStatus();
		WebElement order=driver.findElement(By.id("input-status"));
		Select stat=new Select(order);
		stat.selectByVisibleText("Pending");
		DeletePOM.clickFilterBtn();
		
		//screenShot.captureScreenShot("First");
	}
  	@AfterMethod
	public void quit() throws Exception {
	driver.quit(); 

  	}
}
