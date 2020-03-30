package com.snapdeal.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Product{

	public WebDriver driver;
	public Product(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='add-cart-button-id']")
	WebElement addCart;

	@FindBy(xpath = "//span[@class='total-rating showRatingTooltip']")
	WebElement rating;
	
	@FindBy(xpath="//a[@class='btn marR5']")
	WebElement proceedCheckOut;
	
	@FindBy(xpath="//span[@class='click-tab']")
	WebElement change;
	
	

	public String ratings() {
		return rating.getText();
	}
	
	public ProfileUpdate addToCart() throws IOException {
		addCart.click();
		proceedCheckOut.click();
		change.click();		
		return new ProfileUpdate(driver);
	}
	
	

}
