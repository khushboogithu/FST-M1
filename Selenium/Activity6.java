package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {
        //Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open page
        driver.get("https://training-support.net/webelements/dynamic-controls");
        
        //Title of the page
        System.out.println("Page title: " + driver.getTitle());

        //Checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        
        // Click checkbox
        checkbox.click();
        
        // Check if it is selected
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        
        // Click the checkbox again
        checkbox.click();
        
        // Check if it is selected
        System.out.println("Checkbox is selected: " + checkbox.isSelected());

        // Close browser
        driver.quit();
    }
}
