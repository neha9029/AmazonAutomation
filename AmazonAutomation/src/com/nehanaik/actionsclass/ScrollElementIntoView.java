package com.nehanaik.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.nehanaik.automate.testcases.TestCases.driver;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ScrollElementIntoView {

	private static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static WebElement nextPage = driver.findElement(By.xpath("//span[@id='pagnNextString']"));
	
	
	public static void scrollToChangePage(WebElement element) throws InterruptedException {
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(100,6000);");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",element);

	}


	
}
