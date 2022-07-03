package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By productHeader = By.xpath("//div[@id='content'] //h1");
	private By productImage = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By qty = By.name("quantity");
	private By addToCartBtn = By.id("button-cart");

	public String getProductHeader() {
		String productHeaderText = eleUtil.doGetText(productHeader);
		System.out.println("Product header text is : " + productHeaderText);
		return productHeaderText;
	}

	public int getProductImagesCount() {
		return eleUtil.waitForElementsToBeVisible(productImage, 10).size();
	}

	public Map<String, String> getProductInfo() {
		productInfoMap = new LinkedHashMap<String, String>();
		productInfoMap.put("name", getProductHeader());
		getProductMetaData();
		getPriceMetaData();
		
		return productInfoMap;
	}

	private void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaDataList) {
			String text = e.getText();
			String[] meta = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();

			productInfoMap.put(metaKey, metaValue);
		}
	}
	
	private void getPriceMetaData() {
		List<WebElement> metaPriceList = eleUtil.getElements(productPriceData);
		String price = metaPriceList.get(0).getText().trim();
		String exPrice = metaPriceList.get(1).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("exPrice", exPrice);
	}
}
