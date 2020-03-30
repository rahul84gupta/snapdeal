package com.snapdeal.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.snapdeal.base.Common;

public class Home extends Common {
	public WebDriver driver;
	public Home(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//span[@class='topHooks fastestDel lfloat fastestDelivery']
	@FindBy(xpath = "//div[@id='sdHeader']/div[4]/section/div/span[1]")
	private WebElement tagLine;

	@FindBy(xpath = "//span[@class='cartQuantity']")
	private WebElement quantity;

	@FindBy(id = "inputValEnter")
	private WebElement searchTextbox;

	@FindBy(xpath = "//span[contains(text(),'Search') and @class='searchTextSpan']")
	private WebElement clickOnSearch;

	@FindBy(xpath = "//div[@class='sort-selected']")
	private WebElement clickforsort;

	@FindBy(xpath = "//li[@class='search-li'][2]")
	private WebElement sortLow;

	@FindBy(xpath = "//div[@class='sort-list hidden']/following::section[1]/div[2]")
	List<WebElement> productsList;

	public String tagLineText() {
		return tagLine.getText();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCartQuantity() {
		return quantity.getText();
	}

	public void SearchCriteria() {
		searchTextbox.sendKeys(prop.getProperty("searchcondition"));
		clickOnSearch.click();
	}

	public void sortingLowToHigh() {
		clickforsort.click();
		sortLow.click();
	}

	public Product selectingSecondCheapProduct(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(3000);
		SearchCriteria();
		sortingLowToHigh();
		Thread.sleep(3000);
		List<WebElement> products = productsList;
		for (int i = 0; i <= products.size() - 1; i++) {
			{
				System.out.println(products.get(i).getText());
				products.get(i).click();
			}
		}

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String Parent = itr.next();
		driver.switchTo().window(Parent);
		System.out.println("I am in Parent Window");
		String Child = itr.next();
		Thread.sleep(2000);
		driver.switchTo().window(Child);
		System.out.println("I am in Child Window");
		return new Product(driver);
	}

}
