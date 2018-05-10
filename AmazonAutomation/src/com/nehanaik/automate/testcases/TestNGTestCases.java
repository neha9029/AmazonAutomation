package com.nehanaik.automate.testcases;

import com.nehanaik.automate.pages.HomePage;
import static com.nehanaik.automate.testcases.Constants.*;
import static com.nehanaik.automate.testcases.TestCases.driver;
import com.nehanaik.automate.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nehanaik.datadriven.*;
import com.nehanaik.log4j.logs.LoggingConsole;
import static com.nehanaik.actionsclass.MouseHover.*;
import static com.nehanaik.automate.pages.ProductDescriptionPage.*;
import static com.nehanaik.automate.pages.AddToCartPage.*;
import static com.nehanaik.actionsclass.ScrollElementIntoView.nextPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.nehanaik.actionsclass.*;
import com.nehanaik.datadriven.*;
import com.nehanaik.automate.pages.AddToCartPage;

public class TestNGTestCases {

	public static WebDriver driver;
	//public String webSiteUrl;
	private JavascriptExecutor js;
	private static final Logger log = LogManager.getLogger(TestNGTestCases.class);


	@Test(priority=2, dataProvider="loginData", dataProviderClass= TestDataProvider.class)
	public void testLoginUsingExcel(String email, String password) throws Exception{
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);;
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		boolean emailValidation = driver.findElements(By.xpath("//div[@id='auth-email-missing-alert']")).size() != 0;
		boolean passwordValidation = driver.findElements(By.xpath("//div[@id='auth-password-missing-alert']")).size() != 0;
		boolean passwordIncorrect = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base auth-pagelet-container']")).size() != 0;
		String pass = "Test Failed";
		Assert.assertTrue(emailValidation, pass);
		Assert.assertTrue(passwordValidation, pass);
	}

	@Test(priority=1)
	public void testMethod() throws Exception{

		MouseHover.testMouseHoverLanguage(driver);                                   //Mouse Hover on language Settings
		log.info("Mouse hover on Change Language Settings");
		Thread.sleep(2000);

		MouseHover.testLearnMore(driver, mainElement);                               //Learn More
		log.info("Click on learn more");
		Thread.sleep(2000);

		ChangeLanguageSettings.changeToEspanol(driver);                              // Change to Espanol
		log.info("Change language to Espanol");
		Thread.sleep(2000);

		HomePage.enterSearchText(driver, "Alexa");                                   //enter Search Keyword 
		log.info("Enter the search Text");
		Thread.sleep(2000);

		HomePage.clickOnSearchButton(driver);                                        // click search button 
		log.info("Click on Search button");
		Thread.sleep(2000);

		MouseHover.testMouseHoverLanguage(driver);                                   // Mouse hover on language settings
		log.info("Mouse hover on language settings");
		Thread.sleep(2000);

		MouseHover.testEnglish(driver,mainElement);
		log.info("Change language to English");
		Thread.sleep(2000);
		
		ScrollElementIntoView.scrollToChangePage(nextPage);                           //scroll down to pagination 
		log.info("Scroll nextPage element into view using javascript Executor Interface");
		Thread.sleep(2000);
		
		ProductResultsPage.clickOnNextPage(driver);                                  //next page 
		log.info("Click on next Page");
		Thread.sleep(2000);

		ProductResultsPage.clickOnProduct(driver);                                   //Product Title
		log.info("Click on Product");
		Thread.sleep(2000);
		
		ProductDescriptionPage.selectQty(driver, selectElement);                     //Change Quantity
		log.info("Change Quantity to 3");
		Thread.sleep(2000);

		ProductDescriptionPage.clickOnAddToCartButton(driver,cartElement);           //Add to cart
		log.info("Click on Add to Cart Button");
		Thread.sleep(2000);
		
		AddToCartPage.clickOnProceedToCheckOutButton(driver,proceedToCartElement);   //Proceed to checkout
		log.info("Click on Proceed to Check Out button");
		Thread.sleep(2000);

		//	MouseHover.testMouseHoverSignIn(driver);                                 //Mouse over on SignIn button
		//log.info("Mouse over on Sign In on Main Page");

		//	MouseHover.testSignIn(driver, signInMouseHover);                        //Mouse over in dropdown
		//log.info("Mouse over on Sign In button in dropdown");


	}


	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/nehanaik/selenium/chromedriver");

		driver = new ChromeDriver();
		//webSiteUrl = "https://www.amazon.com/";
		js = (JavascriptExecutor) driver;

		ExcelSheet.setExcelFile("/Users/nehanaik/AmazonLogin.xlsx", "LoginTests");         //Set Excel file path and sheet
		//driver.get(Constants.websiteURL);

		js.executeScript("window.location = 'https://www.amazon.com/';");                  //open window in browser
		log.info("Launching Amazon.com using javascript Executor Interface");

		driver.manage().window().maximize();  //maximize browser window
		Reporter.log("TestNG report -> Setup Executed", true );
		log.info("Maximize window");

	}

	@AfterClass
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		log.info("Terminating the window");                                          //Terminate browser

	}

}
