package com.nehanaik.automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
	
	public static WebElement proceedToCartElement = null;
	
	public static WebElement proceedToCheckOutButton(WebDriver driver) {
		proceedToCartElement = driver.findElement(By.xpath("//a[@class='hucSprite s_checkout hlb-checkout-button']"));
		return proceedToCartElement;
	}
	
	public static void clickOnProceedToCheckOutButton(WebDriver driver, WebElement element) {
		element = proceedToCheckOutButton(driver);
		element.click();
		
	}

}
