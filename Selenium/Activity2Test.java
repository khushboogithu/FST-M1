package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2Test {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/login-form/");
	    System.out.println(driver.getTitle());
	    
	    WebElement userName = driver.findElement(By.id("username"));
	    userName.sendKeys("admin");
	    
	    driver.findElement(By.id("password")).sendKeys("password");
	    
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();    
	    	    
	    System.out.println("Page Title is: " + driver.getTitle());
	    // Perform testing and assertions
	    //...

	    // Close the browser
	    // Feel free to comment out the line below
	    // so it doesn't close too quickly
	    driver.quit();
	  }

}
