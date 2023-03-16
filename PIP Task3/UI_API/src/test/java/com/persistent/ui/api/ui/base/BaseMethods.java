package com.persistent.ui.api.ui.base;

import com.persistent.ui.api.common.enums.DataFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
/**
 * This class contains common elements and methods used across multiple pages of an application, all pages that inherit from it
 */
public class BaseMethods {
    public static WebDriver driver;



    /**
     * Initialize the WebDriver instance
     * This method will run before each test method
     */
    @BeforeTest()
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(DataFile.URL.data);
    }

    /**
     * Closing the web browser
     * this method will run after each test method
     */
    @AfterTest()
    public void teardown() {
        driver.quit();
    }


}


