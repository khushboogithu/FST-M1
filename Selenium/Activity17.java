package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	
public static void main(String[] args) {
		
		// Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/selects");
	    System.out.println(driver.getTitle());
	    
	    WebElement select2 = driver.findElement(By.xpath("//select[@multiple =\"\"]"));
	    Select multiSelect = new Select(select2);
	    
	    //Select the "HTML" option using the visible text.
	    multiSelect.selectByVisibleText("HTML");
	    
	    //Select the 4th, 5th and 6th options using the index.
	    for(int i=3; i<6;i++)
	    {
	    	multiSelect.selectByIndex(i);
	    }	    
	    
	    //Select the "Node" option using the value.
	    multiSelect.selectByVisibleText("NextJS");
	    
	    //De-select the 5th option using index.
	    multiSelect.deselectByIndex(4);	    
	    
	    //Get all the options which are currently selected
	    
	    System.out.println("Selected options are: ");
	    
	    List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
	    
	   for(WebElement selectedOption : selectedOptions)
	   {
		   System.out.println(selectedOption.getText());
	   }
	   
	   //Close the browser
	    driver.quit();
	  
}
}
