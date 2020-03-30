package com.snapdeal.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.snapdeal.base.Common;
import com.snapdeal.pages.CheckOut;
import com.snapdeal.pages.Home;
import com.snapdeal.pages.Login;
import com.snapdeal.pages.Product;
import com.snapdeal.pages.ProfileUpdate;

public class ProfileUpdateTest extends Common {
	public Login login;
	public Home home;
	public Product product;
	public ProfileUpdate profileUpdate;
	public CheckOut checkOut;
	public WebDriver driver;
	public Common com;

	public ProfileUpdateTest() throws IOException {
	}

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws IOException, InterruptedException {
		com = new Common();
		driver = com.initiateBrowser(browser);
		login = new Login(driver);
		home = login.validateLogin(com.prop.getProperty("UserName"), com.prop.getProperty("Password"));
		product = home.selectingSecondCheapProduct(driver);
		profileUpdate = product.addToCart();
	}

	@Test
	public void addressUpdate() throws InterruptedException, IOException {
		profileUpdate.addressChange();
	}

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
