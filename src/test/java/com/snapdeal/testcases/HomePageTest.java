package com.snapdeal.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.snapdeal.base.Common;
import com.snapdeal.pages.Home;
import com.snapdeal.pages.Login;
import com.snapdeal.pages.Product;

public class HomePageTest{
	public Login login;
	public Home home;
	public Product product;
	public WebDriver driver;
	public Common com;

	public HomePageTest() throws IOException {		
	}

	@BeforeClass
	@Parameters("browser")
	public void browserInvoke(String browser) throws IOException, InterruptedException {
		com = new Common();
		driver = com.initiateBrowser(browser);
		login = new Login(driver);
		home = login.validateLogin(com.prop.getProperty("username"), com.prop.getProperty("password"));
	}

	@Test(enabled=false)	
	public void validatePageTitle() {
		System.out.println("Title " );
		String Title= home.getPageTitle();
		String TitleMatch=
				"Login or Register at Snapdeal - Create Account to Get Daily Alert on Deals & Products in Your City";
		System.out.println("Title---->  " + Title);
		Assert.assertEquals(Title.trim(), TitleMatch.trim());
	}

	@Test(enabled=false)	
	public void validateTag() {
		System.out.println("I am in home page");
		String tag= home.tagLineText();
		String ExpectedTag="India's Fastest Online Shopping Destination";
		System.out.println(tag);
//		String actuals="India's Fastest Online Shopping Destination";
//		String compare= home.tagLineText().trim();
		Assert.assertEquals(tag.trim(),ExpectedTag.trim());
	}

	@Test(priority=3)
	public void selectProduct() throws InterruptedException, IOException {
		System.out.println("Running Test Method =3");
		product = home.selectingSecondCheapProduct(driver);
	}

	@AfterTest
	public void tearDown() {
		{	
			driver.close();
			driver.quit();
		}
	}
	
	
}
