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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity7 {
	
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
		
		 
	    @Test(dataProvider = "Credentials")
	    public void loginTest(String username, String password, String expectedMessage) {
	        // Find the input fields and the login button
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
	 
	        // Clear the input fields
	        usernameField.clear();
	        passwordField.clear();
	        // Enter the credentials and click Log in
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	 
	        // Assert login message
	        String loginMessage = driver.findElement(By.id("subheading")).getText();
	        Assert.assertEquals(loginMessage, expectedMessage);
	    }
	    
	    
	    @DataProvider(name = "InvalidCredentials")
	    public Object[][] creds() {
	        return new Object[][] { 
	            { "admin", "incorrectPassword" },
	            { "incorrectAdmin", "password"},
	            { "admin", "@#$%^&*()"},
	            { "DELETE TABLE users", "password"}
	            
	        };
	    }
	    
	    @Test(dataProvider = "InvalidCredentials")
		public void invalidLoginTest(String username, String password, String expectedMessage)
		{
			
			
		}
	    
	    @Test(dataProvider = "ValidCredentials")
		public void validLoginTest(String username, String password, String expectedMessage)
		{
			
			
		}
	 
			
		//Browser cleanup function
		@AfterClass
		public void tearDown()
		{
			//Close the browser
			driver.quit();
			
		}
	

}
