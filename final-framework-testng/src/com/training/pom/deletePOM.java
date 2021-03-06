package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deletePOM {
	private WebDriver driver; 
	
	public deletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(id="input-name")
	private WebElement productname;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catalogLink; 
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(id="button-filter")
	private WebElement filterbtn; 
	
	@FindBy(xpath="//input[@name='selected[]']")
	private WebElement selectBox; 
	
	//@FindBy(xpath="//button[@type='button']")
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickcatalogBtn() {
		this.catalogLink.click(); 
	}
	public void clickproductBtn() {
		this.productLink.click(); 
	}
	public void sendProductName(String productname) {
		this.productname.clear(); 
		this.productname.sendKeys(productname); 
	}
	public void clickFilterBtn() {
		this.filterbtn.click();
	}
	public void clickselectBox() {
		this.selectBox.click();
	}
	public void clickdeleteBtn() {
		this.deleteBtn.click();
		
	
	}
}
