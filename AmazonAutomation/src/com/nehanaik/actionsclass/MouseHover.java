package com.nehanaik.actionsclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.nehanaik.automate.testcases.TestCases;

public class MouseHover {
	
	public static WebElement mainElement = null;
	public static void testMouseHoverLanguage(WebDriver driver) throws Exception {
		
		try {
			 mainElement = driver.findElement(By.xpath("//a[@class=\"nav-a nav-a-2 icp-link-style-2\"]"));
			Thread.sleep(4000);

		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
        {			
			mainElement = driver.findElement(By.xpath("//a[@class=\"nav-a nav-a-2 icp-link-style-2 \"]"));


		}

		
	
		
		
		
		
	   /* Actions newAction = new Actions(driver);
		newAction.moveToElement(mainElement).perform();
		Thread.sleep(2000);

		WebElement learnMore = driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//span[@class='nav-text']//div[@class='icp-helplink']"));
		learnMore.click();   */
	} 

	
	public static void testEnglish(WebDriver driver,WebElement mainElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(mainElement).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement englishElement = driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//span[@class='nav-text']//i[@class='icp-radio']"));
	    englishElement.click();
	    


	}
	
	
	
	public static void testLearnMore(WebDriver driver,WebElement mainElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(mainElement).perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement learnMore = driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//span[@class='nav-text']//div[@class='icp-helplink']"));
		learnMore.click();
		
		//testEspanol(driver, mainElement);

	}

}
