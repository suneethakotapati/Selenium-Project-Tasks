package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object representing the banking manager page
 */
public class BankingManagerPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By addCustomerButton = By.xpath("//button[@ng-click='addCust()']");
    public By openAccountButton = By.xpath("//button[@ng-class='btnClass2']");
    public By customersButton = By.xpath("//button[@ng-class='btnClass3']");

    public BankingManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the "Add Customer" button on the Banking Manager page
     */
    public void clickAddCustomerButton() {

        click(addCustomerButton);
    }

    /**
     * Clicks on the "Open Account" button present on the Banking Manager page
     */
    public void clickOpenAccountButton() {
        click(openAccountButton);
    }

    /**
     * Clicks on the "Customer" button on the Banking Manager page
     */
    public void clickCustomersButton() {
        click(customersButton);
    }

}
