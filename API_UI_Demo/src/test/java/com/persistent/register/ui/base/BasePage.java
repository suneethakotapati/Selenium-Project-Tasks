package com.persistent.register.ui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static String screenshotsSubFolderName;


    /**
     * Initialize browser
     * It will run only once, before all tests in the suite are executed.
     */
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Closing the browser
     * this annotation will be executed when all @Test annotated methods complete the execution of those classes inside the <test> tag
     * If test fails, it will take screenshot
     */

    @AfterMethod
    public void teardown() {
        driver.close();
    }


    public void captureScreenshot(String filename) {
        if (screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);
        }
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/" + screenshotsSubFolderName + "/" + filename);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }
}


