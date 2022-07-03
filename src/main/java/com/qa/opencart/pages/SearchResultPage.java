package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By productresult = By.cssSelector("div.caption a");
	
	public int getProdcutsListCount() {
		int resultCount = eleUtil.waitForElementsToBeVisible(productresult, 5, 2000).size();
		System.out.println("The searched product count is : "+ resultCount);
		return resultCount;
	}
	
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("main product name is : "+mainProductName);
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(productresult, 5, 2000);
		for(WebElement e : searchList) {
			String text = e.getText();
			if(text.equals(mainProductName)) {
				e.click();
				break;
			}
			
		}
		return new ProductInfoPage(driver);
	}

}
