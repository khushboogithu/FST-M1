package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity6Test {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/dynamic-controls");
	    System.out.println(driver.getTitle());
	    
	    //Finding checkbox element
	    WebElement checkBox = driver.findElement(By.id("checkbox"));
	    
	  //Printing visibility of the checkbox
	    System.out.println("Is the checkbox visible? " + checkBox.isSelected());
	    
	    //find and click the button to toggle checkbox
	    driver.findElement(By.xpath("//*[contains(text(),'Toggle')]")).click();

	  //Printing visibility of the checkbox
	    System.out.println("Is the checkbox visible? " + checkBox.isSelected()); 	    
	    
	   driver.quit();
	  }


}
