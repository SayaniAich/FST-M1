package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Activity8 {
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

        //  Find the Dashboard option in the menu and click it.
        driver.findElement(By.cssSelector("#menu_dashboard_index > b")).click();

        //  Click the  Apply Leave button
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        // Select Leave Type
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("DayOff");


        //Fill the from Date
        driver.findElement(By.xpath("//*[@id='frmLeaveApply']/fieldset/ol/li[3]/img")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[5]/a")).click();
        String date = driver.findElement(By.id("applyleave_txtFromDate")).getAttribute("value");
        System.out.println("date: " + date);
        // Fill the Comments
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("please approve");

        //  Click the Apply button
        driver.findElement(By.id("applyBtn")).click();

        //  Click the leave button
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        // identify leave request
        String dateValue =driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[1]/a")).getText();
        System.out.println(dateValue);
        //Assertion for date-value
        Assert.assertEquals(date, dateValue);

        // identify leave status
        String status =driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[6]/a")).getText();
        //Assertion for date-value
        Assert.assertEquals("Pending Approval(1.00)", status);
        // Close the browser
        driver.close();
    }
}
