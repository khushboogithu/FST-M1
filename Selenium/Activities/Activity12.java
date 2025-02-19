package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {
	
	public static void main(String[] args) {
	
	// Initializing a driver
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    
    // Open the browser
    driver.get("https://training-support.net/webelements/dynamic-content");
    System.out.println(driver.getTitle());
    
    //Finding Click button
    driver.findElement(By.id("genButton")).click();
    
    //Wait till release appear on the page
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));
    
    //print the text
    System.out.println(driver.findElement(By.id("word")).getText());
    
    driver.quit();
    
	}   

}
