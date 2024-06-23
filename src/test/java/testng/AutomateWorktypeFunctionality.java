package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AutomateWorktypeFunctionality extends Hooks {
	
	@Test
	public void createWorktype() throws InterruptedException {
		// Create a new instance of the ChromeDriver
					
					Thread.sleep(3000);
					// 2. Click on the toggle menu button from the left corner
					driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();

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
					Thread.sleep(1000);
					String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();

					System.out.println(msg);
					if (msg.contains("created")) {
						System.out.println("WorkType Created");
					} else {
						System.out.println("WorkType not Created");
					}

					
				}

	@Test		
public void createeditWorktype() throws InterruptedException {
	
	
	// Create a new instance of the ChromeDriver
			
			// Click on the toggle menu button from the left corner
		Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();
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


	
