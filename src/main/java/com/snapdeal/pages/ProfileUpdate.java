package com.snapdeal.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.snapdeal.base.Common;
import com.snapdeal.utility.Utility;

public class ProfileUpdate extends Common {
	public WebDriver driver;
	public ProfileUpdate(WebDriver driver) throws IOException {		
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Edit')]")
	 WebElement clickOnEdit;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	
	@FindBy(xpath="//span[@class='button-text']")
	WebElement clickSave;
	
	public void print() {
		System.out.println("printing print method");
	}
	
	public CheckOut addressChange() throws InterruptedException, IOException {
		Utility.explicitWait(driver, clickOnEdit);
		clickOnEdit.click();
		address.click();
		address.clear();		
		address.sendKeys("Deleted R-2/125 RAJ NAGAR" + 
				"Ghaziabad");
		clickSave.click();
		return new CheckOut(driver);		
	}

}
