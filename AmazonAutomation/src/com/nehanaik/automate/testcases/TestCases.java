package com.nehanaik.automate.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nehanaik.automate.pages.HomePage;

public class TestCases {

	 WebDriver driver;
	 String webSiteUrl;
	public static void main(String args[]) {

	
		new TestCases();

	
		
	}
	
	

	public TestCases() {
		
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
	
	public void test() {
		driver.get(webSiteUrl);
		driver.manage().window().maximize();

		HomePage.enterSearcText(driver, "Alexa");
	}
}
