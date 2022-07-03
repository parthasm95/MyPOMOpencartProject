package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.pages.SearchResultPage;
import com.qa.opencart.utils.Constants;

@Listeners(TestAllureListener.class)
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority = 1)
	public void accPageTitleTest() {
		String actTitle = accountPage.getAccountPageTitle();
		System.out.println("Account Page Title is : " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void accPageHeaderTest() {
		String headerTitle = accountPage.getAccountsPageHeaderTitle();
		System.out.println("Account Page Header Title is : " + headerTitle);
		Assert.assertEquals(headerTitle, Constants.ACCOUNT_PAGE_HEADER_TITLE);
	}

	@Test(priority = 3)
	public void isLogoutExistTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}

	@Test(priority = 4)
	public void accPageSectionsTest() {
		List<String> actAccSecList = accountPage.getAccountSecList();
		Assert.assertEquals(actAccSecList, Constants.getExpectedAccSecList());
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "Macbook Pro" }, { "Apple" }, { "Samsung" } };
	}

	@Test(priority = 5, dataProvider = "productData")
	public void searchTest(String productName) {
		Assert.assertTrue(accountPage.isSearchExist());
		searchResultPage = accountPage.doSearch(productName);
		Assert.assertTrue(searchResultPage.getProdcutsListCount()>0);
	}
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { 
			{"macbook", "MacBook Pro" }, 
			{ "apple","Apple Cinema 30\"" },
			{ "Samsung","Samsung SyncMaster 941BW"},
			{ "imac", "iMac"}
		};
		
	}
	
	@Test(priority = 6, dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		searchResultPage  = accountPage.doSearch(productName);
		productInfoPage = searchResultPage.selectProduct(mainProductName);
		String productHeadterText = productInfoPage.getProductHeader();
		Assert.assertEquals(productHeadterText, mainProductName);
	}

}












