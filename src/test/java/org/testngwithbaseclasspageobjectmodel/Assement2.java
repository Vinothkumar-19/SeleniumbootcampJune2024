package org.testngwithbaseclasspageobjectmodel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assement2 {
	// Set up ChromeDriver
    
	ChromeOptions options = new ChromeOptions();
	
	
	 ChromeDriver driver = new ChromeDriver(options);
	 
	 //.manage().timeouts().implicitlyWait(Duration.ofSeconds(30))
	
	
	// 1. Login to https://login.salesforce.com
	driver.get("https://login.salesforce.com");
	// Perform login steps (e.g., enter username and password, click login button)
	driver.findElement(By.id("username")).sendKeys("rajiivino@gmail.com");
	driver.findElement(By.id("password")).sendKeys("Login@1234");
	driver.findElement(By.id("Login")).click();

	// 3. Click View All and click Work Type Groups from App Launcher
	driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]"))
			.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement acc = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
	js.executeScript("arguments[0].click();", acc);

        /*// Step 4: Click Service Console from App Launcher
        WebElement serviceConsole = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Service Console']")));
        serviceConsole.click();

        // Step 5: Select Files from the DropDown
        WebElement filesTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Files']")));
        filesTab.click();

        // Step 6: Click on the latest modified item link
        WebElement latestItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='uiOutputText'][contains(text(), 'Last Modified Date')])[1]")));
        latestItem.click();

        // Step 7: Click on Public link
        WebElement publicLinkButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='Create public link']"))); // Adjust the XPath/selector as needed
        publicLinkButton.click();

        // Step 8: Verify the new link has created
        WebElement publicLinkCreated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Public link created']")));

        // Step 9: Download the file into a specified folder inside the project
        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Download']"))); // Adjust the XPath/selector as needed
        downloadButton.click();

        // Step 10: Click on Share
        WebElement shareButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Share']"))); // Adjust the XPath/selector as needed
        shareButton.click();

        // Step 11: Click on search Bootcamp Testleaf and select the Bootcamp Testleaf
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search people']")));
        searchBox.sendKeys("Bootcamp Testleaf");
        // Adding sleep to wait for the search results to appear
        Thread.sleep(2000);
        WebElement bootcampOption = driver.findElement(By.xpath("//div[contains(text(),'Bootcamp Testleaf')]"));
        bootcampOption.click();

        // Step 12: Verify the Error message "Can't share file with the file owner"
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Can't share file with the file owner']")));

        // Step 13: Remove Bootcamp Testleaf and Search "Integration user"
        WebElement removeButton = driver.findElement(By.xpath("//button[@title='Remove']"));
        removeButton.click();
        searchBox.sendKeys("Integration user");
        // Adding sleep to wait for the search results to appear
         */

}
