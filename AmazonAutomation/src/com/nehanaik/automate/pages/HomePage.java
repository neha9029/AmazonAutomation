package com.nehanaik.automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;
	

	public static WebElement searchBar(WebDriver driver) {
		element = driver.findElement(By.id("twotabsearchtextbox"));
		return element;
		
	}
	
	public static void enterSearcText(WebDriver driver, String searchText) {
		element = searchBar(driver);
		element.sendKeys(searchText);
	}
	
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("input.nav-input"));
		return element;
	}
	
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
}
