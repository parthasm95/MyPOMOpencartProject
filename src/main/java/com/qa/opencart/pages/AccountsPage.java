package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	// 1. Declare Private WebDriver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. Page Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By Locators
	private By headerTitle = By.cssSelector("div#logo img");
	private By accountSections = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink = By.linkText("Logout");

	// 4. page Actions
	public String getAccountPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccountsPageHeaderTitle() {
		return eleUtil.getAttributeValue(headerTitle, "title");
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public void doLogout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
		}
	}
	
	public List<String> getAccountSecList() {
		return eleUtil.getElementsTextListWithWait(accountSections, 10);
	}
	
	public boolean isSearchExist() {
		return eleUtil.doIsDisplayed(searchField);
	}
	
	public SearchResultPage doSearch(String productName) {
		System.out.println("Searching for Product : "+productName);
		eleUtil.doSendKeys(searchField, productName);
		eleUtil.doClick(searchButton);
		return new SearchResultPage(driver);
	}
	

}















