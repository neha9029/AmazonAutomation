package com.nehanaik.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	
	public static WebDriver driver;
	@DataProvider(name = "loginData")
	public Object[][] dataProvider(){
		Object[][] testFeed = ExcelSheet.getTestData("Invalid_Login");
		return testFeed;
	}
	
	
	/*  @Test(dataProvider="loginData")
	  public void testLoginUsingExcel(String email, String password) throws Exception {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);;
		driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		boolean emailValidation = driver.findElements(By.xpath("//div[@id='auth-email-missing-alert']")).size() != 0;
		boolean passwordValidation = driver.findElements(By.xpath("//div[@id='auth-password-missing-alert']")).size() != 0;
		String pass = "Test Failed";
		Assert.assertTrue(emailValidation && passwordValidation,pass);
	  }
      */

}
