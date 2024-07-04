package org.testngwithbaseclassexcelintegration.copy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Baseclass {
public ChromeDriver driver;
	
  
	
	  @DataProvider(name="testdata") 
   public String[][] getData() throws IOException{
		return  ReadExceldata.readData();
	  
	  }
	 
	@BeforeMethod
	public void preCondition() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		// Perform login steps (e.g., enter username and password, click login button)
				driver.findElement(By.id("username")).sendKeys("rajiivino@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Login@1234");
				driver.findElement(By.id("Login")).click();
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (!result.isSuccess()) {
			String Destination ="./Screenshot folder.png";
			TakesScreenshot ss = (TakesScreenshot) driver;
			File source = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(Destination));
		}
		
		//driver.close();
	}
	
	
}
