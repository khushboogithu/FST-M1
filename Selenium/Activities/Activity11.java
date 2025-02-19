package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/dynamic-controls");
	    System.out.println(driver.getTitle());
	    
	    //Finding checkbox element
	    WebElement checkBox = driver.findElement(By.id("checkbox"));
	    
	  //click the element to toggle visibility
	    driver.findElement(By.xpath("//*[contains(text(),'Toggle')]")).click();
	    
	    //Wait for it to disappear
	    wait.until(ExpectedConditions.invisibilityOf(checkBox));
	    
	  //click the button to toggle visibility
	    driver.findElement(By.xpath("//*[contains(text(),'Toggle')]")).click();
	    
	    //wait for the checkbox to appear and click it
	    wait.until(ExpectedConditions.visibilityOf(checkBox)).click();   
	    	    
	    
	   driver.quit();
	  }

}
