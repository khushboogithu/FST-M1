package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Wait;

public class Activity3 {
    public static void main(String[] args) {
        //Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open page
        driver.get("https://training-support.net/webelements/login-form");
       
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
        // enter username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        // enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        // click on login button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Verify confirmation message
        String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
        System.out.println(message);

        // Close browser
        driver.quit();
    }
}
