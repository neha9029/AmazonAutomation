package com.nehanaik.automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductResultsPage {
	public static WebElement element = null;
	
	public static WebElement nextPage(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@id='pagnNextString']"));
		return element;
	}

	public static void clickOnNextPage(WebDriver driver) {
		element = nextPage(driver);
		element.click();
	}
}
