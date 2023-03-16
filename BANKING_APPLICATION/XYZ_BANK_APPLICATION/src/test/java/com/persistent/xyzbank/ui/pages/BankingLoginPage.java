package com.persistent.xyzbank.ui.pages;

import com.persistent.xyzbank.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the login page of a banking website
 */
public class BankingLoginPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * A mechanism for locating elements in the Document Object Model (DOM) using XPath expressions
     */
    public By homePageButton = By.xpath("//button[@class='btn home']");

    public By bankManagerLoginButton = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    public By customerLoginButton = By.xpath("//button[contains(text(),'Customer Login')]");

    public BankingLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on a "Home" button on a banking website
     */
    public void clickHomePageButton() {
        click(homePageButton);
    }

    /**
     * Clicks on a "Customer Login" button on a banking website
     */
    public void clickCustomerLoginButton() {
        click(customerLoginButton);
    }

    /**
     * Clicks on a "Bank Manager Login" button on a banking website
     */
    public void clickBankManagerLoginButton() {
        click(bankManagerLoginButton);

    }


}

