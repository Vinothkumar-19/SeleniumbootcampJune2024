package vennilascripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class Assement2 {

	public static void main(String[] args) throws InterruptedException {
		

        // Configure ChromeOptions for file download location
        String downloadFilepath = Paths.get(System.getProperty("user.dir"), "downloads").toString();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
       // options.addUserProfilePreference("download.default_directory", downloadFilepath);
        ChromeDriver driver = new ChromeDriver(options);

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

  
            // 1. Login to Salesforce
            driver.get("https://login.salesforce.com");
            driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
            driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
            driver.findElement(By.id("Login")).click();

            // Wait until logged in
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("slds-icon-waffle")));

            // 2. Click on toggle menu button from the left corner
            driver.findElement(By.className("slds-icon-waffle")).click();

            // 3. Click view All
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']"))).click();

            // 4. Click Service Console from App Launcher
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Service Console']"))).click();

            // 5. Select Files from the DropDown
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Files"))).click();

            // 6. Click on the latest modified item link
            WebElement latestFile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-aura-class='forceOutputLookup'])[1]")));
            latestFile.click();

            // 7. Click on Public link
            WebElement publicLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Public Link")));
            publicLink.click();

            // 8. Verify the new link has created
            WebElement isLinkCreated = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Link created')]")));
            if (isLinkCreated.isDisplayed()) {
                System.out.println("Public link is created successfully.");
            }

            // 9. Download the file into a specified folder inside the project
            WebElement downloadButton = driver.findElement(By.linkText("Download"));
            downloadButton.click();
            Thread.sleep(10000); // Wait for the download to complete

            // 10. Click on Share
            WebElement shareButton = driver.findElement(By.linkText("Share"));
            shareButton.click();

            // 11. Click on search Bootcamp Testleaf and select the Bootcamp Testleaf
            WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search people']"));
            searchBox.sendKeys("Bootcamp Testleaf");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Bootcamp Testleaf']"))).click();

            // 12. Verify the Error message "Can't share file with the file owner".
            WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='alert']")));
            assert "Can't share file with the file owner".equals(errorMessage.getText());

            // 13. Remove Bootcamp Testleaf and Search "Integration user".
            WebElement removeButton = driver.findElement(By.xpath("//button[@title='Remove Bootcamp Testleaf']"));
            removeButton.click();
            searchBox.clear();
            searchBox.sendKeys("Integration user");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Integration user']"))).click();

            // 14. Add a message as "Bootcamp Testleaf_<your name>"
            WebElement messageBox = driver.findElement(By.xpath("//textarea[@placeholder='Add a message']"));
            messageBox.sendKeys("Bootcamp Testleaf_<Your Name>");

            // 15. Verify "You shared <item> with <shared user>" message
            WebElement shareConfirmButton = driver.findElement(By.xpath("//button[@title='Share']"));
             

	
        }}


