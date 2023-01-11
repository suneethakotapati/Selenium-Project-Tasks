package com.persistent.register.ui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
    public WebDriver driver;
    public static final int DEFAULT_TIMEOUT_SECONDS = 60;

    @BeforeMethod(alwaysRun = true)
    public void createMsEdgeDriver() {

        // setting the path of the Edge driver executable
        //System.setProperty("webdriver.edge.driver","C:\\Users\\Suneetha.Kotapati\\OneDrive - Vertex, Inc\\Documents\\Selenium\\edgedriver_win64 (1)\\msedgedriver.exe");
        // Launch the Edge browser
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }
    @AfterMethod
    public void close(){
        driver.close();
    }

}

