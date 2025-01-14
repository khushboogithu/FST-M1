package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
	
public static void main(String[] args) {
		
		// Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/tabs");
	    System.out.println(driver.getTitle());
	    
	    //Print the current page handle
	    System.out.println("Page handle: " + driver.getWindowHandle());
	    
	    //Find the button to open the new tab
	    driver.findElement(By.xpath("//button[contains(text(),\"Open\")]")).click();    
	    
	    //wait for the new tab to open
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    
	    //Print the windows handles
	    System.out.println("Current Page handle: " + driver.getWindowHandle());
	    
	    //Switch to the new tab
	    for(String handle: driver.getWindowHandles())
	    {
	    	driver.switchTo().window(handle);
	    }
	    
	    //Print the new page 
	    System.out.println("Page title is: " + driver.getTitle());
	    
	    //Print the current page handle
	    System.out.println("Page handle is: " + driver.getWindowHandle());
	    
	    //Print the message on the page
	    System.out.println("Page message is: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());
	    
	    driver.close();
	    //driver.switchTo().defaultContent();
	    
	    //Close the browser
	    driver.quit();
}

}
