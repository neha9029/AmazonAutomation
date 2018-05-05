package com.nehanaik.automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nehanaik.radiobuttons.RadioButtons;


public class ChangeLanguageSettings {
	public static WebElement element = null;

	public static void changeToEspanol(WebDriver driver) {
		clickOnEn(driver);
		RadioButtons.clickOnEspanol(driver);
		//clickOnCancelSettingsButton(driver);
		//cancelSettingsButton(driver);
		
	    saveChangesButton(driver);
        clickOnSaveChangesButton(driver);
	}
	
	/* Changing language to Espanol methods   */
	public static void clickOnEn(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='icp-nav-flyout']//span[@class='icp-nav-language']"));
		element.click();
	}
	
	public static WebElement cancelSettingsButton(WebDriver driver ) {
		//element = driver.findElement(By.xpath("//span[@id='icp-btn-close']//a[@id='icp-btn-close-announce']"));
		element = driver.findElement(By.tagName("Cancel"));
		return element;
		
	}
	public static void clickOnCancelSettingsButton(WebDriver driver) {
		element = cancelSettingsButton(driver);
		element.click();
	}
	
	public static WebElement saveChangesButton(WebDriver driver ) {
		element = driver.findElement(By.xpath("//span[@id='icp-btn-save']//input[@class='a-button-input']"));
		return element;
		
	}
	
	public static void clickOnSaveChangesButton(WebDriver driver) {
		element = saveChangesButton(driver);
		element.click();
	}
	
	
	/*Changing language to English methods */ 
	
    public static void changeToEnglish(WebDriver driver) {
		
	}
    
    public static void clickonEn() {
    	
    }
    
    

}
