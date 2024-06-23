package vennilascripts;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//Import necessary libraries
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Createleditworktype {

	public static void main(String[] args) throws InterruptedException {


		// Create a new instance of the ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//  Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		// Perform login steps (e.g., enter username and password, click login button)
		driver.findElement(By.id("username")).sendKeys("rajiivino@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Login@1234");
		driver.findElement(By.id("Login")).click();
		// Click on the toggle menu button from the left corner

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


