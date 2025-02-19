package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    
	    // Open the browser
	    driver.get("https://training-support.net");
	    System.out.println(driver.getTitle());
	    
	    WebElement AboutUsButton = driver.findElement(By.linkText("About Us"));
	    
	    AboutUsButton.click();
	    
	    System.out.println("Page Title is: " + driver.getTitle());
	    // Perform testing and assertions
	    //...

	    // Close the browser
	    // Feel free to comment out the line below
	    // so it doesn't close too quickly
	    driver.quit();
	  }

}
