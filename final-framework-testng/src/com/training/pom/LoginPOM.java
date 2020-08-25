package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
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
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
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
	
}
