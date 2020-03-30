package com.snapdeal.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.snapdeal.utility.Utility;

public class Login {
	public WebDriver driver;

	public Login(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userName")
	WebElement UserName;

	@FindBy(xpath = "//input[@id='j_password_login_uc' and @type='password']")
	WebElement Password;

	@FindBy(xpath = "//a[contains(text(),'Account')]")
	WebElement ClickAccount;

	@FindBy(xpath = "//div[@class='accountInner']")
	WebElement hover;

	@FindBy(xpath = "//button[@id='submitLoginUC']")
	WebElement clickSubmit;

//	@FindBy(xpath = "//a[contains(text(),'Account')]")
	@FindBy(xpath = "//div[@class='dropdownAccountNonLoggedIn']/div/descendant::a[contains(text(),'Account')]")
	WebElement clicktoaccount;

	@FindBy(xpath = "//button[@id='checkUser']")
	WebElement clickContinue;

	@FindBy(xpath = "//p[@id='back-top']")
	WebElement topArrow;

	public void hover() {
		Utility.fluentWait(driver, hover);
		Utility.hoverOver(driver, hover);
	}

	public void clickAccount() {
		clicktoaccount.click();
	}

	public void setUserName(String un) {
		UserName.sendKeys(un);
	}

	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void clickContinue() {
		clickContinue.click();
	}

	public void clickLogin() {
		clickSubmit.click();
	}

	public String validateGetTitle() {
		return driver.getTitle();
	}

	public void scrollDown() {
		Utility.scrollDown(driver);
	}

	public void clickUpArrow() throws InterruptedException {
		scrollDown();
		Utility.fluentWait(driver, topArrow);
		//Utility.explicitWait(driver, );
		//Thread.sleep(5000);
		topArrow.click();
	}

	public Home validateLogin(String UserName, String Password) throws InterruptedException, IOException {
		try {
			hover();
			Utility.explicitWait(driver, clicktoaccount);//
			clickAccount();
			setUserName(UserName);
			clickContinue();
			setPassword(Password);
			clickLogin();

		} catch (Exception e) {
			e.printStackTrace();

		}
	
		return new Home(driver);
	}

}
