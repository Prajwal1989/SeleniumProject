package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesreportPOM {
	private WebDriver driver; 
	
	public SalesreportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-bar-chart-o fa-fw']")
	private WebElement SalesIcon; 
	
	@FindBy(linkText="Sales")
	private WebElement SalesLink;
	
	@FindBy(linkText="Orders")
	private WebElement OrdersLink;
	
	@FindBy(id="button-filter")
	private WebElement filterbtn; 
	
	@FindBy(xpath="//input[@name='selected[]']")
	private WebElement selectBox; 
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn; 
	
	@FindBy(id="input-group")
	private WebElement filterGrpBy; 
	
	@FindBy(id="input-status")
	private WebElement filterOrderStatus; 

	public void clicksalesIcon() {
		this.SalesIcon.click(); 
	}
	public void clicksalesLink() {
		this.SalesLink.click(); 
	}
	public void clickOrderLink() {
		this.OrdersLink.click();
	}
	public void clickGrpBy() {
		this.filterGrpBy.click();
	}	
		public void clickOrderStatus() {
			this.filterOrderStatus.click();
	}
}
