package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the web page that displays banking information for a specific customer
 */
public class BankingCustomerPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By nameDropdown = By.id("userSelect");
    public By loginButton = By.xpath("//button[contains(text(),'Login')]");

    public BankingCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on the dropdown menu related to a customer's name on a banking website
     */
    public void clickNameDropdown() {
        click(nameDropdown);
    }

    /**
     * Selects a customer's name from a dropdown menu on a banking website
     *
     * @param customerDropdownText selects by visible text from dropdown
     */
    public void selectNameFromDropdown(String customerDropdownText) {
        clickNameDropdown();
        selectDropdown(nameDropdown, customerDropdownText);
    }

    /**
     * Clicks on a "Login" button on a banking website
     */
    public void clickLoginButton() {
        click(loginButton);
    }
}
