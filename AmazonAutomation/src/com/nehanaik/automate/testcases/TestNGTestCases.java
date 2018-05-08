package com.nehanaik.automate.testcases;

//import com.nehanaik.automate.pages.HomePage;
import static com.nehanaik.automate.testcases.Constants.*;
import static com.nehanaik.automate.testcases.TestCases.driver;
import com.nehanaik.automate.pages.*;
import com.nehanaik.datadriven.*;
import static com.nehanaik.actionsclass.MouseHover.mainElement;
import static com.nehanaik.actionsclass.MouseHover.signInMouseHover;
import static com.nehanaik.actionsclass.ScrollElementIntoView.nextPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.nehanaik.actionsclass.*;
import com.nehanaik.datadriven.*;
import com.nehanaik.automate.pages.ChangeLanguageSettings;

public class TestNGTestCases {

	public static WebDriver driver;
	//public String webSiteUrl;
	private JavascriptExecutor js;


	@Test(priority=2, dataProvider="loginData", dataProviderClass= TestDataProvider.class)
	public void testLoginUsingExcel(String email, String password) throws Exception {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);;
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		boolean emailValidation = driver.findElements(By.xpath("//div[@id='auth-email-missing-alert']")).size() != 0;
		boolean passwordValidation = driver.findElements(By.xpath("//div[@id='auth-password-missing-alert']")).size() != 0;
		boolean passwordIncorrect = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base auth-pagelet-container']")).size() != 0;
		String pass = "Test Failed";
		Assert.assertTrue(emailValidation,pass);
		Assert.assertTrue(passwordValidation, pass);
	}

	@Test(priority=1)
	public void testMethod() throws Exception {

		//MouseHover.testMouseHoverLanguage(driver);
		//MouseHover.testLearnMore(driver, mainElement);
		//ChangeLanguageSettings.changeToEspanol(driver);
		HomePage.enterSearchText(driver, "Alexa");                       //enter Search Keyword 
		HomePage.clickOnSearchButton(driver);                            // click search button 
		//	MouseHover.testMouseHoverLanguage(driver);
		//	MouseHover.testEnglish(driver,mainElement);
		//ScrollElementIntoView sc = new ScrollElementIntoView();

		Thread.sleep(2000);
		ScrollElementIntoView.scrollToChangePage(nextPage);             //scrolldown to pagination 
		Thread.sleep(2000);
		ProductResultsPage.clickOnNextPage(driver);                     //nextpage 
		ProductResultsPage.clickOnProduct(driver);                      //click on Product Title
		Thread.sleep(2000);
		MouseHover.testMouseHoverSignIn(driver);
		MouseHover.testSignIn(driver, signInMouseHover);


	}


	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/nehanaik/selenium/chromedriver");

		driver = new ChromeDriver();
		//webSiteUrl = "https://www.amazon.com/";
		js = (JavascriptExecutor) driver;
		//ExcelSheet.setExcelFile(Constants.File_path + Constants.File_name, "LoginTests");

		ExcelSheet.setExcelFile("/Users/nehanaik/AmazonLogin.xlsx", "LoginTests");
		//driver.get(Constants.websiteURL);

		js.executeScript("window.location = 'https://www.amazon.com/';"); 
		driver.manage().window().maximize();  //maximize browser window

	}

	@AfterClass
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
