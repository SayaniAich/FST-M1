package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity5 {
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

        //  Click the Edit button
        driver.findElement(By.id("btnSave")).click();

        // Fill the firstName field and enter the value
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Test");
        // Fill the lastName field and enter the value
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Test123");
        // Select gender button

        WebElement radioElement = driver.findElement(By.id("personal_optGender_1"));
        boolean selectState = radioElement.isSelected();

        //performing click operation only if element is not selected
        if(!selectState) {
            radioElement.click();
        }

        // Select Nationality
        Select nation = new Select(driver.findElement(By.id("personal_cmbNation")));
        nation.selectByVisibleText("Indian");

        //Find the dob

        WebElement dateBox = driver.findElement(By.id("personal_DOB"));

        //Fill date

        dateBox.sendKeys("1987-01-01");

        //  Click the Save button
        driver.findElement(By.id("btnSave")).click();

        // Close the browser
        driver.close();
    }
}
