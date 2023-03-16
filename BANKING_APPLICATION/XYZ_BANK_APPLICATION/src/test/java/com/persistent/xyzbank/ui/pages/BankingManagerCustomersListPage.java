package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the page displayed to the bank manager when viewing a list of customers.
 * It provides methods to retrieve information about the customers on the list
 */
public class BankingManagerCustomersListPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By tableRow = By.xpath("//table/tbody/tr");
    public By searchCustomerTextBox = By.xpath("//input[@placeholder='Search Customer']");
    public By deleteButton = By.xpath("//button[contains(text(),'Delete')]");

    public BankingManagerCustomersListPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Retrieves the contents of a specified row in a table
     *
     * @param firstName text to match on ui
     * @return an array
     */
    public String[] getTableRow(String firstName) {

        return getCustomerDetails(tableRow, firstName);
    }

    /**
     * Sets the name of the second customer in a search box
     *
     * @param data the data to set in the search box
     */
    public void setSecondCustomerInSearchTextBox(String data) {
        sendKeys(searchCustomerTextBox, data);
    }

    /**
     * Clicks the delete button for a specified item.
     */
    public void clickDeleteButton() {
        click(deleteButton);
    }

    /**
     * Sets the name of the first customer in a search box
     *
     * @param firstCustomerName sets the first customer name in search box
     */
    public void setFirstCustomerInSearchTextBox(String firstCustomerName) {
        sendFirstCustomerNameInSearchBar(searchCustomerTextBox, firstCustomerName);
    }

    /**
     * Checks a customer account for a specified account number
     *
     * @return True if the account exists, false otherwise
     */
    public boolean checkCustomerAccount() {
        return checkPresenceOfElement(tableRow);
    }
}
