package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class OrderPage {
	
	String order;
	private By check = By.id("check");
	
	public void orderProduct() {
		System.out.println("order id is 1234" + check);
	}

}
