package org.testngwithbaseclasspageobjectmodel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Baseclass1 {
	public ChromeDriver driver;
	
	/*
	 * @Parameters({})
	 * 
	 * @DataProvider(name="testdata") public Object[][] getData(){
	 * 
	 * return new Object[][] {
	 * 
	 * {}
	 * 
	 * }; }
	 */
	@BeforeMethod
	public void preCondition() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		
		
	}
	@AfterMethod
	public void tearDown() throws IOException {
		
		//ITestResult result

		/*
		 * if (!result.isSuccess()) { String Destination ="./Screenshot folder.png";
		 * TakesScreenshot ss = (TakesScreenshot) driver; File source =
		 * ss.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(source, new
		 * File(Destination)); }
		 */
		
		//driver.close();
	}
	
	
}
