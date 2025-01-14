package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {
	
public static void main(String[] args) {
		
		// Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/alerts");
	    System.out.println(driver.getTitle());
	    
	    //Find the button to open a SIMPLE alert and click it.
	    driver.findElement(By.id("simple")).click();
	    
	    //Switch the focus from the main window to the Alert box and get the text in it and print it.
	    Alert simpleAlert = driver.switchTo().alert(); 
	    
	    //Close the alert once with OK.
	    simpleAlert.accept();	 
	    
	    //Print the message
	    System.out.println("Action performed was: " + driver.findElement(By.id("result")).getText());
	    
	    //Activity19
	    
	    //Find the button to open a Confirmation alert and click it.
	    driver.findElement(By.id("confirmation")).click();
	    
	    //Switch the focus from the main window to the Alert box and get the text in it and print it.
	    Alert confirmationAlert = driver.switchTo().alert(); 
	    
	    //Close the alert once with OK.
	    confirmationAlert.accept();	 
	    
	    //Print the message
	    System.out.println("Action performed was: " + driver.findElement(By.id("result")).getText());
	    
	    //Activity20
	    
	   //Find the button to open a Prompt alert and click it.
	    driver.switchTo().defaultContent();
	    driver.findElement(By.id("prompt")).click();
	    
	    //Switch the focus from the main window to the Alert box and get the text in it and print it.
	    Alert promptAlert = driver.switchTo().alert();
	    
	    //Enter the Text on alert.
	    promptAlert.sendKeys("Test"); 
	    promptAlert.accept();    
	    
	    //Print the message
	    System.out.println("Action performed was: " + driver.findElement(By.id("result")).getText());
	    
	    //Close the browser
	    driver.quit(); 
	
}

}
