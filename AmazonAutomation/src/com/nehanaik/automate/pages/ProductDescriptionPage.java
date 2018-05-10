package com.nehanaik.automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.nehanaik.radiobuttons.Dropdowns;


public class ProductDescriptionPage {

	public static WebElement selectElement = null;
	public static WebElement cartElement = null;

	
	public static WebElement qtyDropdown(WebDriver driver) {
	
		selectElement = driver.findElement(By.xpath("//span[@class='a-dropdown-container']//select[@id='quantity']"));
		return selectElement;
	}
	
	public static void selectQty(WebDriver driver, WebElement element) {
		element = qtyDropdown(driver);
		Dropdowns.selectOptionFromDropDown(element); 
	}
	
	
	public static WebElement addToCartButton(WebDriver driver) {
		cartElement = driver.findElement(By.id("add-to-cart-button"));
		return cartElement;
		
	}
	
	public static void clickOnAddToCartButton(WebDriver driver, WebElement element) {
		element = addToCartButton(driver);
		element.click();
	}
	
}
