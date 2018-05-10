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
	
	//Change result_0 to any other no for clicking on other products
	public static WebElement productTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='atfResults']//li[@id='result_16']//div[@class='a-row a-spacing-none']"));
		//element = driver.findElement(By.xpath("/html//ul[@id='s-results-list-atf']/li[1]//div[@class='a-fixed-left-grid-inner']//a[@title='Echo Dot Kids Edition, a smart speaker with Alexa for kids - blue case']/h2"));
		return element;
	}
	
	public static void clickOnProduct(WebDriver driver) {
		element = productTitle(driver);
		element.click();
	}
}
