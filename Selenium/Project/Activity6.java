package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity6 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the username field and enter the username
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        // Find the password field and enter the password
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        // Find the login button and click it
        driver.findElement(By.id("btnLogin")).click();

        //  Find the Directory option in the menu and click it.
        WebElement element  = driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b"));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }

        // identify Header
        String header =driver.findElement(By.xpath("//div[@class='head']")).getText();
        //Assertion for page title
        Assert.assertEquals("Search Directory", header);

        // Close the browser
        driver.close();
    }
}
