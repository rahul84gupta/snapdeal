package com.snapdeal.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
		home = login.validateLogin(com.prop.getProperty("UserName"), com.prop.getProperty("Password"));
	}

	@Test(priority=1)	
	public void validatePageTitle() {
		String Title= home.getPageTitle();
		String TitleMatch=
				"Login or Register at Snapdeal - Create Account to Get Daily Alert on Deals & Products in Your City";
		Assert.assertEquals(Title.trim(), TitleMatch.trim());
	}

	@Test(priority=2)	
	public void validateTag() throws InterruptedException {
		Thread.sleep(2000);
		String tag= home.tagLineText();
		String ExpectedTag="India's Fastest Online Shopping Destination";
		Assert.assertEquals(tag.trim(),ExpectedTag.trim());
	}

	@Test(priority=3)
	public void selectProduct() throws InterruptedException, IOException {
		System.out.println("Running Test Method =3");
		product = home.selectingSecondCheapProduct(driver);
	}

	@AfterClass
	public void tearDown() {
		{	
			driver.close();
			driver.quit();
		}
	}
	
	
}
