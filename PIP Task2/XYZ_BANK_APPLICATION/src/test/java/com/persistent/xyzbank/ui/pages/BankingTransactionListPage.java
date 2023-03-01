package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the page for displaying the transaction list of a banking account
 */
public class BankingTransactionListPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By transactionButton = By.xpath("//button[contains(text(),'Transactions')]");
    public By backButton = By.xpath("//button[contains(text(),'Back')]");
    public By transactionTableRow = By.xpath("//table/tbody/tr");

    public BankingTransactionListPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the "Transaction" button on the page
     */
    public void clickTransactionButton() {
        click(transactionButton);
    }

    public String[] getTransactionRow() {
        String[] transactionRecord = getTransactionRecord(transactionTableRow);

        if (transactionRecord.length == 0) {
            click(backButton);
            click(transactionButton);
            transactionRecord = getTransactionRecord(transactionTableRow);
        }
        return transactionRecord;
    }

    /**
     * Clicks the "Back" button in the browser navigation
     */
    public void clickBackButton() {
        click(backButton);
    }
}
