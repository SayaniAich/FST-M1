package Project;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    // Test method
    @Test
    public void addTasks() throws InterruptedException {
        String notetitle="Sample notes";
        String description="Sample description added for reference";
        By title=AppiumBy.id("index_note_title");

        // perform task addition
            driver.findElement(AppiumBy.id("new_note_button")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title"))).sendKeys(notetitle);
            driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(description);
            driver.findElement(AppiumBy.className("android.widget.ImageButton")).click();
            Assert.assertEquals(driver.findElement(title).getText(),notetitle);
            Assert.assertEquals(driver.findElement(AppiumBy.id("index_note_text_description")).getText(),description);

    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}