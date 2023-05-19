package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
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

        //  Find the MyInfo option in the menu and click it.
        driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b")).click();

        //  Click the  Qualification button
        driver.findElement(By.linkText("Qualifications")).click();
        //  Click the  Add  button
        driver.findElement(By.id("addWorkExperience")).click();

        // Fill the Company field and enter the value
        driver.findElement(By.id("experience_employer")).sendKeys("Test");
        // Fill the Job field and enter the value
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test123");

        //Find the dob
        driver.findElement(By.id("experience_from_date")).sendKeys("1987-01-01");

        //  Click the Save button
        driver.findElement(By.id("btnWorkExpSave")).click();

        // Close the browser
        driver.close();
    }
}
