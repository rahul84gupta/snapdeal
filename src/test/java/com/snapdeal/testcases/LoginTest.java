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

public class LoginTest {
	public Login Login;
	public Home home;
	public WebDriver driver;
	public Common com;

	public LoginTest() throws IOException {
	}

	@BeforeClass
	@Parameters("browser")
	public void browserInitiate(String browser) throws IOException {
		com = new Common();
		driver = com.initiateBrowser(browser);
		Login = new Login(driver);
	}

	@Test(priority = 2, groups = "First Group")
	public void validateTitle() throws IOException {
		String title = Login.validateGetTitle();
		System.out.println(title);
		Assert.assertEquals(title,
				"Online Shopping Site India - Shop Electronics, Mobiles, Men & Women Clothing, Shoes - www. Snapdeal.com");
	}

	@Test(priority = 3, groups = "First Group")
	public void validateUserLogin() throws InterruptedException, IOException {
		Thread.sleep(3000);				
		System.out.println(com.prop.getProperty("UserName"));
		home=Login.validateLogin(com.prop.getProperty("UserName"), com.prop.getProperty("Password"));
		//home = Login.validateLogin(com.prop.getProperty("username"), com.prop.getProperty("password"));
	}

	@Test(priority = 1, groups = "First Group")
	public void checkScrollDown() throws InterruptedException {
		Login.clickUpArrow();
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
