package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity4 {
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

        //  Find the PIM option in the menu and click it.
        driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).click();

        //  Click the Add button
        driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
        System.out.println("Clicked on Add button");

        // Find the firstName field and enter the value
        driver.findElement(By.id("firstName")).sendKeys("TestNew");
        // Find the lastName field and enter the value
        driver.findElement(By.id("lastName")).sendKeys("Test1234");
        // Find the Save button and click it
        driver.findElement(By.id("btnSave")).click();

        // Check the first name in Employee List tab
        String firstName = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
        System.out.println("firstName: " + firstName);

        //Assertion for Value
        Assert.assertEquals("TestNew", firstName);

        // Check the last name in Employee List tab
        String lastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
        System.out.println("lastName: " + lastName);

        //Assertion for Value
        Assert.assertEquals("Test1234", lastName);

        System.out.println("Employee details have been verified ");
        // Close the browser
        driver.close();
    }
}
