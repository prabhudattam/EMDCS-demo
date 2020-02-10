package com.emdcs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.emdcs.qa.util.TestUtil;
import com.emdcs.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
		
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src\\test\\java\\com\\emdcs\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		String browserName1 = prop.getProperty("browser1");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriverPath"));	
			
			driver = new ChromeDriver(); 
			
		}
		else if(browserName1.equals("ie")){
			System.setProperty("webdriver.ie.driver",prop.getProperty("IEPath"));;	
			driver = new InternetExplorerDriver(); 
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		}

}
