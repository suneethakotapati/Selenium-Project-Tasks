package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents a page where a bank manager can add a new customer
 */
public class BankingManagerAddCustomerPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By firstName = By.xpath("//input[@placeholder='First Name']");
    public By lastName = By.xpath("//input[@placeholder='Last Name']");
    public By postCode = By.xpath("//input[@placeholder='Post Code']");
    public By addCustomerButtonAfterPostCode = By.xpath("//button[@type='submit']");

    public BankingManagerAddCustomerPage(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Sets the first name of the first customer on the "Add Customer" page
     *
     * @param firstCustomerFirstName the first name to set for the first customer
     */
    public void setFirstCustomerFirstName(String firstCustomerFirstName) {
        sendKeys(firstName, firstCustomerFirstName);
    }

    /**
     * Sets the last name of the first customer on the "Add Customer" pag
     *
     * @param firstCustomerLastName the lastname to set for the first customer
     */
    public void setFirstCustomerLastName(String firstCustomerLastName) {
        sendKeys(lastName, firstCustomerLastName);
    }

    /**
     * Sets the post code of the first customer on the "Add Customer" page
     *
     * @param firstCustomerPostCode the postcode to set for the first customer
     */
    public void setFirstCustomerPostCode(String firstCustomerPostCode) {
        sendKeys(postCode, firstCustomerPostCode);
    }

    /**
     * Sets the first name of the second customer on the "Add Customer" page
     *
     * @param secondCustomerFirstName the first name to set for the second customer
     */
    public void setSecondCustomerFirstName(String secondCustomerFirstName) {
        sendKeys(firstName, secondCustomerFirstName);
    }

    /**
     * Sets the last name of the second customer on the "Add Customer" page
     *
     * @param secondCustomerLastName the last name to set for the second customer
     */
    public void setSecondCustomerLastName(String secondCustomerLastName) {
        sendKeys(lastName, secondCustomerLastName);

    }

    /**
     * Sets the post code of the second customer on the "Add Customer" page
     *
     * @param secondCustomerPostCode the postcode to set for the second customer
     */
    public void setSecondCustomerPostcode(String secondCustomerPostCode) {
        sendKeys(postCode, secondCustomerPostCode);
    }

    /**
     * Clicks the "Add Customer" button on the "Add Customer" page after the post code has been entered
     */
    public void clickAddCustomerButtonAfterPostCode() {
        click(addCustomerButtonAfterPostCode);
    }

    /**
     * get customer ID from alert text
     *
     * @return Customer ID
     */
    public int getCustomerId() {
        return waitForAlertPresentAndGetId();
    }
}
