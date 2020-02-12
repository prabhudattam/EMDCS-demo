package com.emdcs.qa.testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.emdcs.qa.base.TestBase;
import com.emdcs.qa.pages.HomePage;
import com.emdcs.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(com.emdcs.qa.testdata.LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(description="Verify Vechile Transfer application")
	public void loginTest() throws InterruptedException {
		homePage=loginPage.login(prop.getProperty("un"),prop.getProperty("pwd"));
		System.out.println("Login Successfully");
		Thread.sleep(5000);
		System.out.println("Select the Delaer Code");
		Select Dealer = new Select(driver.findElement(By.name("dealerCodeSelect")));
		Dealer.selectByVisibleText("1010222");
		System.out.println("showing retrieve inventory list");
		driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[5]/td/div/font/a")).click(); 
		Thread.sleep(5000);
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing Browser");
			driver.quit();	
	}

}
