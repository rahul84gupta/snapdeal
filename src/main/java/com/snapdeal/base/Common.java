package com.snapdeal.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.snapdeal.utility.WebEventListener;

public class Common {
	public  WebDriver driver;
	public  Properties prop;
	public  EventFiringWebDriver e_driver;
	public  WebEventListener eventListener;
	public  String Basepath;
	
//	public static void main(String args[]) throws IOException {
//		Basepath= System.getProperty("user.dir");
//		System.out.println(Basepath);
//		 prop = new Properties();
//		FileInputStream fis = new FileInputStream(Basepath+"\\src\\main\\java\\com\\snapdeal\\config\\config.properties");
//		prop.load(fis);
//		System.out.println(prop.getProperty("UserName"));
//	}
	
	public Common() throws IOException {
		 Basepath= System.getProperty("user.dir");
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(Basepath+"\\src\\main\\java\\com\\snapdeal\\config\\config.properties");
		prop.load(fis);
	}
	
	
	
	public WebDriver initiateBrowser(String browser) throws IOException {
		 String Browser = browser; //prop.getProperty("browser");
		if(Browser.equals("chrome"))
		{			
//			ChromeOptions co = new ChromeOptions();
//			 co.addArguments("Headless");
			System.setProperty("webdriver.chrome.driver", Basepath+"\\drivers\\chromedriver.exe");			 
			driver = new ChromeDriver();			 
		}else if(Browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Basepath+"\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;		
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		driver.get("https://www.snapdeal.com");
		return driver;
		
	}

}
