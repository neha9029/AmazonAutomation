package com.nehanaik.automate.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.nehanaik.actionsclass.MouseHover;
import com.nehanaik.automate.pages.HomePage;

public class TestCases {

	public WebDriver driver;
	public String webSiteUrl;
	public static void main(String args[]) throws Exception {

	
		new TestCases();

	}
	
	

	public TestCases() throws Exception {
		
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test();
	}



	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/nehanaik/selenium/chromedriver");

		driver = new ChromeDriver();
		webSiteUrl = "https://www.amazon.com/";
		
	}
	
	public void test() throws Exception {
		driver.get(webSiteUrl);
		driver.manage().window().maximize();

		MouseHover.testMouseHover(driver);

		HomePage.enterSearchText(driver, "Alexa");
		HomePage.clickOnSearchButton(driver);
		
	}
	

}
