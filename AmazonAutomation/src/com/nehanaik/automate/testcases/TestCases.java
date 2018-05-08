package com.nehanaik.automate.testcases;

//import com.nehanaik.automate.pages.HomePage;
import static com.nehanaik.automate.testcases.Constants.*;
import com.nehanaik.automate.pages.*;
import com.nehanaik.datadriven.*;
import static com.nehanaik.actionsclass.MouseHover.mainElement;
import static com.nehanaik.actionsclass.MouseHover.signInMouseHover;
import static com.nehanaik.actionsclass.ScrollElementIntoView.nextPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import com.nehanaik.actionsclass.*;
import com.nehanaik.datadriven.*;

import com.nehanaik.automate.pages.ChangeLanguageSettings;


public class TestCases {

	public static WebDriver driver;
	//public String webSiteUrl;
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



	/* Method to Set the Chrome browser driver */
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/nehanaik/selenium/chromedriver");

		driver = new ChromeDriver();
		//webSiteUrl = "https://www.amazon.com/";
		js = (JavascriptExecutor) driver;
		ExcelSheet.setExcelFile(Constants.File_path + Constants.File_name, "LoginTests");

	}

	
	/* Method to Quit the browser */
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

/*	public void UsingExcelToTest(){
		@DataProvider(name = "loginData")
		public Object[][] dataProvider(){
			
		}
		

	}
	
	*/
	
	/* Method to test all the functionalities */
	public void test() throws Exception {
		//driver.get(Constants.websiteURL);

		js.executeScript("window.location = 'https://www.amazon.com/';"); 
		driver.manage().window().maximize();  //maximize browser window

		//	MouseHover.testMouseHoverLanguage(driver);
		//	MouseHover.testLearnMore(driver, mainElement);
		//ChangeLanguageSettings.changeToEspanol(driver);
		HomePage.enterSearchText(driver, "Alexa");                       //enter Search Keyword 
		HomePage.clickOnSearchButton(driver);                            // click search button 
		//	MouseHover.testMouseHoverLanguage(driver);
		//	MouseHover.testEnglish(driver,mainElement);
		//ScrollElementIntoView sc = new ScrollElementIntoView();

		ScrollElementIntoView.scrollToChangePage(nextPage);             //scrolldown to pagination 
		Thread.sleep(2000);
		ProductResultsPage.clickOnNextPage(driver);                     //nextpage 
        ProductResultsPage.clickOnProduct(driver);                      //click on Product Title
		Thread.sleep(2000);
		MouseHover.testMouseHoverSignIn(driver);
		MouseHover.testSignIn(driver, signInMouseHover);
		//closeWindow();


	}
	
	


}


