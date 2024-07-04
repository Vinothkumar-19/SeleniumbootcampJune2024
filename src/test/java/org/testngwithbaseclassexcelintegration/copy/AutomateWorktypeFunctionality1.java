package org.testngwithbaseclassexcelintegration.copy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;


public class AutomateWorktypeFunctionality1 extends Baseclass {
	
	@Test(dataProvider="testdata")////retryAnalyzer = FailedRetry.class,
	public void createWorktype(String Automation) throws InterruptedException {
		/// Create a new instance of the ChromeDriver
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));  

		// Replace Thread.sleep(3000) with explicit wait
		WebElement toggleMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='App Launcher']//div")));

		// Click on the toggle menu button from the left corner
		toggleMenuButton.click();

					// 3. Click View All and click Work Type Groups from App Launcher
					driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]"))
							.click();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					WebElement acc = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
					js.executeScript("arguments[0].click();", acc);

					// 4. Click on the Dropdown icon in the Work Type Groups tab
					// WebElement dropdownIcon =
					// driver.findElement(By.cssSelector("locator_for_dropdown_icon"));
					// dropdownIcon.click();

					// 5. Click on New Work Type Group
					driver.findElement(By.className("forceActionLink")).click();

					// 6. Enter Work Type Group Name as 'Salesforce Automation by Your Name'
					driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).sendKeys("Automation");

					// 7. Click save and verify Work Type Group Name

					WebElement acc1 = driver.findElement(By.xpath("//span[text()='Save']"));

					driver.executeScript("arguments[0].click();", acc1);

					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@title='OK']")).click();

					WebElement acc2 = driver.findElement(By.xpath("//button[text()='Save']"));
					driver.executeScript("arguments[0].click();", acc2);

					// Verify the Created message
					
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(1000));  // Set the timeout as 10 seconds

					// Replace Thread.sleep(1000) with explicit wait
					WebElement toastMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
					String msg = toastMessage.getText();
					//Thread.sleep(1000);
					//String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();

					System.out.println(msg);
					/*
					 * if (msg.contains("created")) { System.out.println("WorkType Created"); } else
					 * { System.out.println("WorkType not Created"); }
					 */
					
					if (msg.contains("created")) {
					    Assert.assertTrue(true);
					} else {
					    Assert.assertFalse(false);
					}

					
				}
	
	
	@Test()//retryAnalyzer = FailedRetry.class
	public void createeditWorktype() throws InterruptedException {
	
	
	// Create a new instance of the ChromeDriver
			
			// Click on the toggle menu button from the left corner
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));  

		// Replace Thread.sleep(3000) with explicit wait
		WebElement toggleMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='App Launcher']//div")));

		// Click on the toggle menu button from the left corner
		toggleMenuButton.click();
		//Thread.sleep(3000);
			//driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();
			// 3. Click View All and click Work Type Groups from App Launcher
			driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]"))
			.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement acc = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
			js.executeScript("arguments[0].click();", acc);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@part='input']")).sendKeys("AutomationAutomation1");
			driver.findElement(By.linkText("Automation")).click();
			driver.findElement(By.xpath("//button[contains(@class,'test-id__inline-edit-trigger slds-shrink-none')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).sendKeys("2");
			driver.findElement(By.xpath("//button[text()='Save']")).click();

		}}


	
