package com.snapdeal.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	public WebDriver driver;
	public CheckOut(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
