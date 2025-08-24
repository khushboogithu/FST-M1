package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {
	
	//Declaring the driver object
	WebDriver driver;
	
	//Declaring the wait object
	WebDriverWait wait;
	
	//Browser setup function
	@BeforeClass
	public void setup()
	{
		//Initialize the driver
		driver = new FirefoxDriver();
		
		//Initialize the wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the page
		driver.get("https://training-support.net/webelements/login-form");		
	}
	
	@Test(priority = 1)
	public void homePageTest()
	{
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
		
	}
	
	@Test(dependsOnMethods = {"homePageTest"})
	public void loginPageTest()
	{
		// username and password 
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
 
        // Enter credentials
        username.sendKeys("admin");
        password.sendKeys("password");
 
        // Click login
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
 
        // login confirmation message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);
		
	}	
		
	//Browser cleanup function
	@AfterClass
	public void tearDown()
	{
		//Close the browser
		driver.quit();
		
	}

}
