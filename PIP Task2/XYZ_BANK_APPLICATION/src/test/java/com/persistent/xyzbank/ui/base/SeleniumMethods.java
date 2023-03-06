package com.persistent.xyzbank.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * This class is used to pause the execution of the test until certain conditions are met
 */
public class SeleniumMethods extends SeleniumWaits {
    /**
     * This method is used to interact with web elements on a web page, such as clicking on buttons, links, checkboxes, and radio buttons
     *
     * @param click used to locate elements on a web page
     */
    public void click(By click) {
        WebElement element = driver.findElement(click);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    /**
     * This method is used to interact with text-based elements on a web page
     *
     * @param textBox used to locate elements on a web page
     * @param text    sending text to text boxes
     */
    public void sendKeys(By textBox, String text) {
        WebElement element = driver.findElement(textBox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Wraps a WebElement with functionality to select options from a drop-down.
     *
     * @param dropdown  used to locate elements on a web page
     * @param textForDropdown the text to match
     */
    public void selectDropdown(By dropdown, String textForDropdown) {
        WebElement element = driver.findElement(dropdown);
        Select select = new Select(element);
        select.selectByVisibleText(textForDropdown);
    }

    /**
     * getting all customer table details
     * if any row matches the firstname we will be retrieving the matching row
     * and splitting the row by space and saving the matched details in an array and returning it
     * else returning the empty array of size 0
     *
     * @param customer  used to locate elements on a web page
     * @param firstName the text to match
     * @return returning an array
     */
    public String[] getCustomerDetails(By customer, String firstName) {
        List<WebElement> elements = driver.findElements(customer);
        for (WebElement element : elements) {
            if (element.getText().contains(firstName)) {
                String data = element.getText();
                String[] tableCustomerData;
                tableCustomerData = data.split(" ");
                return tableCustomerData;
            }
        }
        return new String[0];
    }

    /**
     * Gets the text from a UI element.
     *
     * @param getTextElement used to locate elements on a web page
     * @return the text of the WebElement
     */
    public String getTextFromUi(By getTextElement) {
        WebElement element = driver.findElement(getTextElement);
        return element.getText();
    }

    /**
     * Gets the text from the inner HTML of a UI element
     *
     * @param message used to locate elements on a web page
     * @return the text of the WebElement's inner HTML
     */
    public String getAttributeFromInnerHtml(By message) {
        WebElement element = driver.findElement(message);
        return element.getAttribute("innerHTML");
    }

    /**
     * Retrieving transaction table rows
     * if there are elements present in the transaction table, last row is the latest transaction made
     * by user so retrieving the full row and splitting the row based on spaces and saving them in an array and returning the array
     * else returning the empty array of size 0
     * @param transactionTable the By object used to locate the transaction table elements
     * @return returning an array
     */
    public String[] getTransactionRecord(By transactionTable) {
        List<WebElement> elements = driver.findElements(transactionTable);
        int size = elements.size();
        if (size > 0) {
            String data = elements.get(size - 1).getText();
            String[] transaction;
            transaction = data.split(" ");
            return transaction;
        } else {
            String[] transaction;
            transaction = new String[0];
            return transaction;
        }
    }

    /**
     * Types the name of the first customer in the search bar.
     * @param customer used to locate elements on a web page
     * @param customerName text to textBox
     */
    public void sendFirstCustomerNameInSearchBar(By customer, String customerName) {
        WebElement textField = driver.findElement(customer);
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(customerName);
        textField.sendKeys(Keys.ENTER);
    }

    /**
     * Checks if an element is present on the web page
     * @param locator the By object used to locate the element
     * @return true if the element is present, false otherwise
     */
    public Boolean checkPresenceOfElement(By locator) {
        int size = driver.findElements(locator).size();
        return size > 0;
    }
    public void waitForStaleElement(By staleElement){
        waitForStaleElement(driver.findElement(staleElement));


    }
}





