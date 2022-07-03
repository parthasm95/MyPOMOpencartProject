package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login11";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER_TITLE = "naveenopencart11";
	
	public static final  String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final int DEFAULT_TIME_OUT = 5;
	public static final int IMAC_IMAGE_COUNT = 3;
	
	public static final String LOGIN_ERROR_MESSG = "No match for E-Mail Address and/or Password.";
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "registration";
	
	public static List<String> getExpectedAccSecList() {
		List<String> expsecList = new ArrayList<String>();
		expsecList.add("My Account");
		expsecList.add("My Orders");
		expsecList.add("My Affiliate Account");
		expsecList.add("Newsletter");
		
		return expsecList;
	}

}
