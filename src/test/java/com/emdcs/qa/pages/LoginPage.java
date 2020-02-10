package com.emdcs.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emdcs.qa.base.TestBase;
import com.emdcs.qa.pages.HomePage;


public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password; 
	
	@FindBy(xpath="//input[@name='SUBMIT']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[text()=\'Click here to reset it.\']")
	WebElement reset;
	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
}
