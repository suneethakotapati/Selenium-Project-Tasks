package com.persistent.register.ui.base;

import com.persistent.register.ui.enums.DataFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;

    /**
     * Initialize browser
     * It will run only once, before all tests in the suite are executed.
     */
    @BeforeMethod(alwaysRun = true)
    public void createMsEdgeDriver() {
        // setting the path of the Edge driver executable
        // System.setProperty("webdriver.edge.driver","C:\\Users\\Suneetha.Kotapati\\OneDrive - Vertex, Inc\\Documents\\Selenium\\edgedriver_win64 (1)\\msedgedriver.exe");
        // Launch the Edge browser
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(DataFile.LOGIN_URL.data);
    }

    /**
     * Closing the browser
     * this annotation will be executed when all @Test annotated methods complete the execution of those classes inside the <test> tag
     * If test fails, it will take screenshot
     */

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = System.getProperty("user.dir") + "/screenshots/" + testResult.getName() + ".png";
            File screenshotFile = new File(filePath);
            FileUtils.copyFile(screenshot, screenshotFile);
            driver.close();
        }
    }

}


