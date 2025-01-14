package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	
public static void main(String[] args) {
		
		// Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/selects");
	    System.out.println(driver.getTitle());
	    
	    WebElement select1 = driver.findElement(By.tagName("select"));
	    Select dropdown = new Select(select1);
	    
	    //Select the second option using the visible text.
	    dropdown.selectByVisibleText("Two");
	    System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
	    
	    //Select the third option using the index.
	    dropdown.selectByIndex(3);
	    System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
	    
	    //Select the fourth option using the value.
	    dropdown.selectByValue("four");
	    System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
	    
	    //Get all the options and print them to the console.
	    
	   for(WebElement option : dropdown.getOptions())
	   {
		   System.out.println(option.getText());
	   }
	  
	 // close the browser
	    driver.quit();
	
}

}
