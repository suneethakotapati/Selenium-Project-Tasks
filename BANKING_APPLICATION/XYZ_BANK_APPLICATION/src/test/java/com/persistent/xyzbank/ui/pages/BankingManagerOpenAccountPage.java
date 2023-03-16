package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the page where a bank manager can open a new account for a customer
 */
public class BankingManagerOpenAccountPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By customerDropdown = By.id("userSelect");
    public By currencyDropdown = By.id("currency");
    public By processButton = By.xpath("//button[contains(text(),'Process')]");

    public BankingManagerOpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on the customer dropdown element to show the list of customers
     */
    public void clickCustomerDropdown() {
        click(customerDropdown);
    }

    /**
     * Clicks on the currency dropdown element to show the list of currencies
     */
    public void clickCurrencyDropdown() {
        click(currencyDropdown);
    }

    /**
     * Selects the specified customer from the dropdown element
     *
     * @param customerDropdownText the visible text of the customer to select
     */
    public void selectFromCustomerDropdown(String customerDropdownText) {
        clickCustomerDropdown();
        selectDropdown(customerDropdown, customerDropdownText);
    }

    /**
     * Selects the specified currency from the dropdown element
     *
     * @param currencyDropdownText currencyName the name of the currency to select
     */
    public void selectFromCurrencyDropdown(String currencyDropdownText) {
        clickCurrencyDropdown();
        selectDropdown(currencyDropdown, currencyDropdownText);
    }

    /**
     * Clicks the "process" button
     *
     * @return account number
     */
    public int clickProcessButton() {
        click(processButton);
        return waitForPresentAndGetAccountNumber();
    }
}
