package com.tutorialsninja_Nov04_TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_Dummy {
	
	public WebDriver driver;
	//public ChromeOptions options;
	
	@BeforeMethod
	public void loginSetup() {
		//driver = initializeBrowserAndOpenApplication("chrome");//
		/*options = new ChromeOptions();
		//driver.manage().window().maximize();//using options method and incognito mode,
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");*/
		//System.out.println("IT is our good class");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}

	@Test(priority =1)
  public void verifyLoginWithValidCredentials() {	
	driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	WebElement editYourAccountInfoLink = driver.findElement(By.linkText("Edit your account information"));
	WebElement logoutLink = driver.findElement(By.linkText("Logout"));
	
	Assert.assertTrue(editYourAccountInfoLink.isDisplayed() && logoutLink.isDisplayed() );
	}
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpShanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("AutSelenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarnigMessage = "Warning: No match for E-Mail Address and/or Password." ;
		Assert.assertTrue(actualWarningMessage.contains(expectedWarnigMessage) );
	}
	@Test(priority=3)
	public void verifyLoginWithInValidPassword() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("AutSelenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarnigMessage = "Warning: No match for E-Mail Address and/or Password." ;
		Assert.assertTrue(actualWarningMessage.contains(expectedWarnigMessage) );
	}
	@Test(priority=4)
	public void verifyLoginWithInValidEmailAndValidPassWord() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpweShanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarnigMessage = "Warning: No match for E-Mail Address and/or Password." ;
		Assert.assertTrue(actualWarningMessage.contains(expectedWarnigMessage) );
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
