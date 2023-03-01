package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the page object for a banking account page
 * It provides methods to interact with elements on the page, such as
 * checking account balances,deposits and withdrawal's
 */
public class BankingAccountPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By welcomeUserName = By.xpath("//span[contains(text(),'sunitha Kota')]");
    public By accountNumber = By.xpath("//strong[@class='ng-binding'][1]");
    public By balanceAccount = By.xpath("//strong[@class='ng-binding'][2]");
    public By withdrawButton = By.xpath("//button[contains(text(),'Withdrawl')]");
    public By withdrawAmountTextBox = By.xpath("//input[@placeholder='amount']");
    public By depositAmountTextBox = By.xpath("//input[@placeholder='amount']");
    public By withdrawSubmitButton = By.xpath("//button[@type='submit']");
    public By depositSubmitButton = By.xpath("//button[@type='submit']");
    public By withdrawnMessage = By.xpath("//span[@class='error ng-binding']");
    public By depositMessage = By.xpath("//span[@class='error ng-binding']");
    public By depositButton = By.xpath("//button[@ng-click='deposit()']");

    public BankingAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets the text from a UI element on the welcome page
     *
     * @return the text contained in the identified UI element
     */
    public String getTextFromUiWelcomePage() {

        return getTextFromUi(welcomeUserName);
    }

    /**
     * Gets the account number from a UI element
     *
     * @return the account number contained in the identified UI element
     */
    public String getTextFromUiAccountNumber() {
        return getTextFromUi(accountNumber);
    }

    /**
     * Gets the account balance from a UI element
     *
     * @return the account balance contained in the identified UI element
     */
    public String getTextFromUiAccountBalance() {
        waitForPresentElement(balanceAccount);
        waitForVisibilityElement(balanceAccount);
        return getTextFromUi(balanceAccount);
    }

    /**
     * Clicks the "Withdraw" button on the current page
     */

    public void clickWithdrawButton() {
        click(withdrawButton);
    }

    /**
     * Sets the amount to be withdrawn in a UI element
     *
     * @param amount the amount to be withdrawn
     */
    public void setAmountToBeWithdrawn(String amount) {
        sendKeys(withdrawAmountTextBox, amount);
    }

    /**
     * Clicks the "Submit" button on the current page
     */
    public void clickSubmitButton() {
        waitForPresentElement(withdrawSubmitButton);
        waitForVisibilityElement(withdrawSubmitButton);
        click(withdrawSubmitButton);
    }

    /**
     * Clicks the "Deposit" button on the current page
     */
    public void clickDepositButton() {
        click(depositButton);
    }

    /**
     * Sets the amount to be deposited in a UI element
     *
     * @param deposit the amount to be deposited
     */
    public void setAmountToBeDeposit(String deposit) {

        waitForPresentElement(depositAmountTextBox);
        waitForClickElement(depositAmountTextBox);
        sendKeys(depositAmountTextBox, deposit);
    }

    /**
     * Clicks the "Deposit Submit" button on the deposit page
     */
    public void clickDepositSubmitButton() {

        click(depositSubmitButton);
    }

    /**
     * Retrieves the message related to a withdrawal transaction from a UI element
     *
     * @param withdrawnAmount Sets the amount to be withdrawn in a UI element
     * @return the withdrawal message as a string
     */
    public String withdrawMessageFromUi(String withdrawnAmount) {
        clickWithdrawButton();
        setAmountToBeWithdrawn(withdrawnAmount);
        clickSubmitButton();
        return getAttributeFromInnerHtml(withdrawnMessage);
    }

    /**
     * Retrieves the message related to a deposit transaction from a UI element
     *
     * @param depositAmount Sets the amount to be deposited in a UI element
     * @return the deposit message as a string
     */
    public String depositMessageFromUi(String depositAmount) {
        try {
            clickDepositButton();
            waitForPresentElement(depositAmountTextBox);
            waitForClickElement(depositAmountTextBox);
            click(depositAmountTextBox);
            waitForPresentElement(depositAmountTextBox);
            waitForClickElement(depositAmountTextBox);
            setAmountToBeDeposit(depositAmount);
            clickDepositSubmitButton();
            return getAttributeFromInnerHtml(depositMessage);
        } catch (StaleElementReferenceException e) {
            clickDepositButton();
            waitForPresentElement(depositAmountTextBox);
            waitForClickElement(depositAmountTextBox);
            click(depositAmountTextBox);
            waitForPresentElement(depositAmountTextBox);
            waitForClickElement(depositAmountTextBox);
            setAmountToBeDeposit(depositAmount);
            clickDepositSubmitButton();
            return getAttributeFromInnerHtml(depositMessage);
        }
    }
}
