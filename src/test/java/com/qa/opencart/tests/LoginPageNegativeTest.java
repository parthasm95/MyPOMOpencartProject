package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest{
	
	@DataProvider
	public  Object[][] loginWrongTestData() {
		return new Object[][] {
			{"abc@gmail.com","1112233"},
			{"psmohapatra99@gmail.com","PP@1111"},
			{"abc@gmail.com","Psm@9595"},
			{"abc@gmail.com",""},
			{"","1112233"},
			{"",""}
		};
	}
	
	@Test(dataProvider = "loginWrongTestData")
	public void loginNegativeTest(String username, String password) {
		Assert.assertFalse(loginPage.doLoginWithWrongCredentials(username, password));;
	}

}
