package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	
public static void main(String[] args) {
		
		// Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	    
	        
	    // Open the browser
	    driver.get("https://training-support.net/webelements/dynamic-attributes");
	    System.out.println(driver.getTitle());
	    
	    //find the full name field and enter the details
	    driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Ksbu");
	    
	   //find the email and enter the details
	    driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("Ksbu@example.com");
	    
	   //find the date fields and enter the details, date must be entered as YYYY-MM-DD
	    //driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]")).sendKeys("2025-01-14");
	    driver.findElement(By.xpath("//input[@type=\"date\"]")).sendKeys("2025-01-14");	    
	    
	    //find the Additional details field and enter the details
	    //driver.findElement(By.xpath("//textarea[contains(@name,'-additional-details-')]")).sendKeys("Happy Sankranti");
	    driver.findElement(By.xpath("//textarea[contains(@name,'-additional-details-')]")).sendKeys("Happy Sankranti");
	    	    
	    //find and click the submit button
	    driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
	    
	    // To print confirmation message
	    
	    String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();

	    System.out.println(message);
	    
	    // close the browser
	    driver.quit();
	    
	    
}

}
