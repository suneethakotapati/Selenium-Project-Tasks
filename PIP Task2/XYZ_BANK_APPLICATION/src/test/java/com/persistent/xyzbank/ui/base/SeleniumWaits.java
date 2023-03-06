package com.persistent.xyzbank.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is used to pause the execution of the test until certain conditions are met
 */
public class SeleniumWaits extends BaseMethods {
    /**
     * This method is used to check if an element is present in the HTML DOM of a page
     *
     * @param by used to locate elements on a web page
     */
    public void waitForPresentElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This method is used to check if an element is visible on the page, and it waits until the element is visible before continuing the test
     *
     * @param by used to locate elements on a web page
     */
    public void waitForVisibilityElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * This method is used to checks that the element is visible, enabled, and positioned correctly on the page before considering it clickable.
     *
     * @param by used to locate elements on a web page
     */
    public void waitForClickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    /**
     * Waits for an alert to be present and returns text ID from alert
     *
     * @return the ID from the alert
     */

    public int waitForAlertPresentAndGetId() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String id = driver.switchTo().alert().getText();
        int index = id.indexOf(":");
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return Integer.parseInt(id.substring(index + 1));
    }

    /**
     * Waits for an alert to be present and returns account number from alert
     *
     * @return the account number from the alert
     */
    public int waitForPresentAndGetAccountNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String accountNumber = driver.switchTo().alert().getText();
        int index = accountNumber.indexOf(":");
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return Integer.parseInt(accountNumber.substring(index + 1));
    }

    /**
     * Use ExpectedConditions. refreshed to avoid StaleElementReferenceException and retrieve the element again.
     * This method updates the element by redrawing it, and we can access the referenced element.
     *
     * @param element on a web page
     */
    public void waitForStaleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
    }
}

