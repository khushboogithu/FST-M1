package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1_Test {
    WebDriver driver;
    
    // Setup function
    @BeforeClass
    public void setUp() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        // Open the page
        driver.get("https://training-support.net");
    }
    
    // Test function
    @Test(priority = 1)
    public void pageTitleTest() {
        // Get the page title and verify it.
        Assert.assertEquals(driver.getTitle(), "Training Support");
        
        //Open the page
        driver.get("https://training-support.net");        
        
    }
    
    @Test(priority = 2)
    public void aboutPageTest() {
    	// Find and click the About us link
        driver.findElement(By.linkText("About Us")).click();
        
        //verify the new page title
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
    
    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
