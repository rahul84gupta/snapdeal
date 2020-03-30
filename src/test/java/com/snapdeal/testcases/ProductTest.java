package com.snapdeal.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.snapdeal.base.Common;
import com.snapdeal.pages.Home;
import com.snapdeal.pages.Login;
import com.snapdeal.pages.Product;
import com.snapdeal.pages.ProfileUpdate;

public class ProductTest {
	public Login login;
	public Home home;
	public Product product;
	public ProfileUpdate profileUpdate;
	public WebDriver driver;
	public Common com;

	public ProductTest() throws IOException {
		// super();
	}

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws IOException, InterruptedException {
		com = new Common();
		driver = com.initiateBrowser(browser);
		login = new Login(driver);
		home = login.validateLogin(com.prop.getProperty("username"), com.prop.getProperty("password"));
		product = home.selectingSecondCheapProduct(driver);
	}

	@Test
	public void addingInCart() throws IOException {
		profileUpdate = product.addToCart();
	}

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();

	}

}
