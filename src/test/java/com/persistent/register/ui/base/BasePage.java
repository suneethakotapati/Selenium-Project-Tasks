package com.persistent.register.ui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public static final int DEFAULT_TIMEOUT_SECONDS = 60;
    public String baseUrl="https://demoqa.com/automation-practice-form";

    @BeforeMethod(alwaysRun = true)
    public void createMsEdgeDriver() {
        // setting the path of the Edge driver executable
        // System.setProperty("webdriver.edge.driver","C:\\Users\\Suneetha.Kotapati\\OneDrive - Vertex, Inc\\Documents\\Selenium\\edgedriver_win64 (1)\\msedgedriver.exe");
        // Launch the Edge browser
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }

}

