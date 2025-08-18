package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {
    public static void main(String[] args) {
        //Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open page
        driver.get("https://training-support.net/webelements/target-practice");
        // title of the page
        System.out.println("Page title: " + driver.getTitle());

        //3rd header
        String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
        System.out.println(thirdHeaderText);
        //5th header
        Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
        System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
        System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());

        //violet button
        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
        System.out.println(purpleButtonClass);
        //grey button
        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
        System.out.println(slateButtonText);

        // Close browser
        driver.quit();
    }
}