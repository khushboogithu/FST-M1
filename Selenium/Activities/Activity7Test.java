package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7Test {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/dynamic-controls");
	    System.out.println(driver.getTitle());
	    
	    //Finding input box element
	    WebElement textInputBox = driver.findElement(By.id("textInput"));
	    
	  //Printing visibility of the input box
	    System.out.println("Is the input box enabled? " + textInputBox.isEnabled());
	    
	    //find and click the button enable input
	    driver.findElement(By.xpath("//button[@id='textInputButton']")).click();

	  //Printing visibility of the input box
	    System.out.println("Is the input box enabled? " + textInputBox.isEnabled() ); 	    
	    
	   driver.quit();
	  }

}
