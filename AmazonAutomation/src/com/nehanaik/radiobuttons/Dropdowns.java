package com.nehanaik.radiobuttons;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	
	public static void selectOptionFromDropDown(WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue("3");
		//sel.selectByIndex(2);
		//sel.selectByVisibleText("3");
		System.out.println("Options in Quantity Dropdown: ");
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for(int i = 0;i<size;i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
			
		}
	}
}
