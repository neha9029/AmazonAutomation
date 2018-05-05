package com.nehanaik.radiobuttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtons {

	
	
	
	public static void clickOnEspanol(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[@class='a-radio a-radio-fancy']//input[@value='es_US']")));
		WebElement radioButtonEspanol = driver.findElement(By.xpath("//div[2]/div[@class='a-radio a-radio-fancy']//input[@value='es_US']"));

		Actions actions = new Actions(driver);
		if(!radioButtonEspanol.isSelected()) {
			actions.moveToElement(radioButtonEspanol).click().build().perform();
		   // radioButtonEspanol.click();
		}
		
	    
	
	}
}
