package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

@Listeners(TestAllureListener.class)
public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void setupRegistration() {
		registrationPage = loginPage.goToRegisterPage();
	}
	
	public String getRandomEmail() {
		Random randomgenerator = new Random();
		String email = "automation"+randomgenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastname, String telephone, String password, String subscribe) {
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastname, getRandomEmail(), telephone, password, subscribe));
	}

}
