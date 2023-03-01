package com.persistent.register.ui.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;



import static com.persistent.register.common.SeleniumWaits.timeout;

public class SeleniumMethods extends BasePage {
    /**
     * This method will used to send-data to textboxes,dropdowns
     *
     * @param by
     * @param text
     */
    public void sendKeys(By by, String text) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        Assert.assertEquals(true, element.isEnabled());
        Assert.assertTrue(true, "Assert passed");
    }

    /**
     * This method will used to Click textboxes, radio buttons and checkboxes
     *
     * @param by
     */
    public void clickBox(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(by).click();
    }

    /**
     * This method will used to Click textboxes
     *
     * @param by
     */
    public void click(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[0].click();", element);
        Assert.assertEquals(true, element.isSelected());
        System.out.println("Assert Passed");
    }

    /**
     * This method will used to Submitting the form
     *
     * @param b1
     */
    public void submit(By b1) {
        timeout();
        WebElement element = driver.findElement(b1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(b1));
        element.submit();

    }

    /**
     * This method will used to Get the text from popup
     *
     * @param b2
     */
    public void popUp(By b2) {
        timeout();
        WebElement element = driver.findElement(b2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "Thanks for submitting the form");
        System.out.println("Assertion for Ui is Passed");
    }


    /**
     * This method is used to send text to dropdwons
     *
     * @param by
     * @param text
     */
    public void sendTextToDropdown(By by, String text) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(text);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
    }

    /**
     * This method is used to select the date from calender
     *
     * @param by
     * @param text
     */
    public void dateSelector(By by, String text) {
        WebElement textField = driver.findElement(by);
        textField.sendKeys(Keys.PAGE_UP);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", textField);
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(text);
        textField.sendKeys(Keys.ENTER);
    }

    /**
     * This method will used to send the data to the subject dropdown
     *
     * @param by
     * @param text
     */
    public void subjectSelector(By by, String text) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.sendKeys(Keys.PAGE_UP);
        element.sendKeys(text);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(Keys.ENTER);
    }
}










