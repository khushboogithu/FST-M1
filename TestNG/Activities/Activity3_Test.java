package activities;

import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.SkipException;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Activity3_Test {
	WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://training-support.net/webelements/login-form");
    }

    // Test function
    @Test(priority = 1)
    public void pageTitleTest() {
        // Get the page title and verify it.
        Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");    
               
        
    }
    
    @Test(priority = 2)
    public void loginFormTest() {
    	// Find the user name field and enter the username
    	driver.findElement(By.id("username")).sendKeys("admin");
    	
    	// Find the password field and enter the password
    	driver.findElement(By.id("password")).sendKeys("password");
    	
    	// Find the Submit button and click on it
    	driver.findElement(By.xpath("//button[text()='Submit']")).click();
                
        //verify the login message
    	String message = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(message, "Welcome Back, Admin!");
    }
    
    @AfterTest
    public void afterMethod() {
        // Close the browser
        driver.close();
    }
}
