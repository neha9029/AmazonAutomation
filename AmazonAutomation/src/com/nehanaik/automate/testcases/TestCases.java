package com.nehanaik.automate.testcases;

//import com.nehanaik.automate.pages.HomePage;
import com.nehanaik.automate.pages.*;
import static com.nehanaik.actionsclass.MouseHover.mainElement;
import static com.nehanaik.actionsclass.ScrollElementIntoView.nextPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import com.nehanaik.actionsclass.*;

import com.nehanaik.automate.pages.ChangeLanguageSettings;

public class TestCases {

	public static WebDriver driver;
	public String webSiteUrl;
	private JavascriptExecutor js;
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
		js = (JavascriptExecutor) driver;

	}

	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public void test() throws Exception {
		//driver.get(webSiteUrl);

		js.executeScript("window.location = 'https://www.amazon.com/';");
		driver.manage().window().maximize();

		//	MouseHover.testMouseHoverLanguage(driver);
		//	MouseHover.testLearnMore(driver, mainElement);
		//ChangeLanguageSettings.changeToEspanol(driver);
		HomePage.enterSearchText(driver, "TV");
		HomePage.clickOnSearchButton(driver);
		//	MouseHover.testMouseHoverLanguage(driver);
		//	MouseHover.testEnglish(driver,mainElement);
		//ScrollElementIntoView sc = new ScrollElementIntoView();

		ScrollElementIntoView.scrollToChangePage(nextPage);
		Thread.sleep(2000);
		ProductResultsPage.clickOnNextPage(driver);

		Thread.sleep(2000);
		closeWindow();


	}


}
