package com.persistent.xyzbank.ui.tests;

import com.persistent.xyzbank.common.enums.DataFile;
import com.persistent.xyzbank.ui.base.BaseMethods;
import com.persistent.xyzbank.ui.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * This class is used to run the all the Test cases
 */
@Listeners(com.persistent.xyzbank.common.listeners.Listener.class)
public class XYZBankTests extends BaseMethods {
    WebDriver driver;
    BankingLoginPage bankingLoginPage;
    BankingManagerPage bankingManagerPage;
    BankingManagerAddCustomerPage bankingManagerAddCustomerPage;
    BankingManagerOpenAccountPage bankingManagerOpenAccountPage;
    BankingManagerCustomersListPage bankingManagerCustomersListPage;
    BankingCustomerPage bankingCustomerPage;
    BankingAccountPage bankingAccountPage;
    BankingTransactionListPage bankingTransactionListPage;


    @Test
    public void addCustomers(ITestContext context) {
        bankingLoginPage = new BankingLoginPage(driver);
        bankingManagerPage = new BankingManagerPage(driver);
        bankingManagerAddCustomerPage = new BankingManagerAddCustomerPage(driver);
        bankingManagerOpenAccountPage = new BankingManagerOpenAccountPage(driver);
        bankingManagerCustomersListPage = new BankingManagerCustomersListPage(driver);
        bankingTransactionListPage = new BankingTransactionListPage(driver);
        bankingCustomerPage = new BankingCustomerPage(driver);
        bankingAccountPage = new BankingAccountPage(driver);
        bankingLoginPage.clickBankManagerLoginButton();

        //Adding first customer account
        bankingManagerPage.clickAddCustomerButton();
        bankingManagerAddCustomerPage.setFirstCustomerFirstName(DataFile.FIRST_CUSTOMER_FIRSTNAME.data);
        bankingManagerAddCustomerPage.setFirstCustomerLastName(DataFile.FIRST_CUSTOMER_LASTNAME.data);
        bankingManagerAddCustomerPage.setFirstCustomerPostCode(DataFile.FIRST_CUSTOMER_POSTCODE.data);
        bankingManagerAddCustomerPage.clickAddCustomerButtonAfterPostCode();

        //save first customer id
        int firstCustomerId = bankingManagerAddCustomerPage.getCustomerId();


        //Adding second customer account
        bankingManagerAddCustomerPage.setSecondCustomerFirstName(DataFile.SECOND_CUSTOMER_FIRSTNAME.data);
        bankingManagerAddCustomerPage.setSecondCustomerLastName(DataFile.SECOND_CUSTOMER_LASTNAME.data);
        bankingManagerAddCustomerPage.setSecondCustomerPostcode(DataFile.SECOND_CUSTOMER_POSTCODE.data);
        bankingManagerAddCustomerPage.clickAddCustomerButtonAfterPostCode();

        //save second customer id
        int secondCustomerId = bankingManagerAddCustomerPage.getCustomerId();
        Assert.assertNotEquals(firstCustomerId, secondCustomerId);
        Assert.assertFalse(firstCustomerId <= 0 && secondCustomerId <= 0);
        Assert.assertFalse(Integer.toString(firstCustomerId).isEmpty());
        Assert.assertFalse(Integer.toString(secondCustomerId).isEmpty());


        //checking customers account
        bankingManagerPage.clickCustomersButton();
        String[] firstCustomerData = bankingManagerCustomersListPage.getTableRow(DataFile.FIRST_CUSTOMER_FIRSTNAME.data);
        String[] secondCustomerData = bankingManagerCustomersListPage.getTableRow(DataFile.SECOND_CUSTOMER_FIRSTNAME.data);
        Assert.assertNotEquals(firstCustomerData.length, 0);
        Assert.assertNotEquals(secondCustomerData.length, 0);
        String actualFirstCustomerFirstName = firstCustomerData[0];
        String actualFirstCustomerLastName = firstCustomerData[1];
        String actualFirstCustomerPostCode = firstCustomerData[2];
        String actualSecondCustomerFirstName = secondCustomerData[0];
        String actualSecondCustomerLastName = secondCustomerData[1];
        String actualSecondCustomerPostCode = secondCustomerData[2];

        Assert.assertEquals(actualFirstCustomerFirstName, DataFile.FIRST_CUSTOMER_FIRSTNAME.data);
        Assert.assertEquals(actualFirstCustomerLastName, DataFile.FIRST_CUSTOMER_LASTNAME.data);
        Assert.assertEquals(actualFirstCustomerPostCode, DataFile.FIRST_CUSTOMER_POSTCODE.data);
        Assert.assertEquals(actualSecondCustomerFirstName, DataFile.SECOND_CUSTOMER_FIRSTNAME.data);
        Assert.assertEquals(actualSecondCustomerLastName, DataFile.SECOND_CUSTOMER_LASTNAME.data);
        Assert.assertEquals(actualSecondCustomerPostCode, DataFile.SECOND_CUSTOMER_POSTCODE.data);


        //opening account for customers
        bankingManagerPage.clickOpenAccountButton();
        String firstName = DataFile.FIRST_CUSTOMER_FIRSTNAME.data + " ";
        String lastName = DataFile.FIRST_CUSTOMER_LASTNAME.data;
        String firstCustomerUserName = firstName.concat(lastName);
        context.setAttribute("firstCustomerUserName", firstCustomerUserName);


        //save first customer account number
        bankingManagerOpenAccountPage.selectFromCustomerDropdown(firstCustomerUserName);
        bankingManagerOpenAccountPage.selectFromCurrencyDropdown(DataFile.CURRENCY_VALUE.data);
        int firstCustomerAccountNumber = bankingManagerOpenAccountPage.clickProcessButton();
        context.setAttribute("firstCustomerAccountNumber", firstCustomerAccountNumber);


        //save second customer account number
        firstName = DataFile.SECOND_CUSTOMER_FIRSTNAME.data + " ";
        lastName = DataFile.SECOND_CUSTOMER_LASTNAME.data;
        String secondCustomerUserName = firstName.concat(lastName);
        bankingManagerOpenAccountPage.selectFromCustomerDropdown(secondCustomerUserName);
        bankingManagerOpenAccountPage.selectFromCurrencyDropdown(DataFile.CURRENCY_VALUE.data);
        int secondCustomerAccountNumber = bankingManagerOpenAccountPage.clickProcessButton();

        //checking customers account with account number
        bankingManagerPage.clickCustomersButton();
        Assert.assertNotEquals(firstCustomerAccountNumber, secondCustomerAccountNumber);
        String[] firstCustomerDetails = bankingManagerCustomersListPage.getTableRow(DataFile.FIRST_CUSTOMER_FIRSTNAME.data);
        String[] secondCustomerDetails = bankingManagerCustomersListPage.getTableRow(DataFile.SECOND_CUSTOMER_FIRSTNAME.data);
        Assert.assertNotEquals(firstCustomerDetails.length, 0);
        Assert.assertNotEquals(secondCustomerData.length, 0);
        actualFirstCustomerFirstName = firstCustomerDetails[0];
        actualFirstCustomerLastName = firstCustomerDetails[1];
        actualFirstCustomerPostCode = firstCustomerDetails[2];
        int expectedFirstCustomerAccountNumber = Integer.parseInt(firstCustomerDetails[3]);
        actualSecondCustomerFirstName = secondCustomerDetails[0];
        actualSecondCustomerLastName = secondCustomerDetails[1];
        actualSecondCustomerPostCode = secondCustomerDetails[2];
        int expectedSecondCustomerAccountNumber = Integer.parseInt(secondCustomerDetails[3]);
        Assert.assertEquals(actualFirstCustomerFirstName, DataFile.FIRST_CUSTOMER_FIRSTNAME.data);
        Assert.assertEquals(actualFirstCustomerLastName, DataFile.FIRST_CUSTOMER_LASTNAME.data);
        Assert.assertEquals(actualFirstCustomerPostCode, DataFile.FIRST_CUSTOMER_POSTCODE.data);
        Assert.assertEquals(firstCustomerAccountNumber, expectedFirstCustomerAccountNumber);
        Assert.assertEquals(actualSecondCustomerFirstName, DataFile.SECOND_CUSTOMER_FIRSTNAME.data);
        Assert.assertEquals(actualSecondCustomerLastName, DataFile.SECOND_CUSTOMER_LASTNAME.data);
        Assert.assertEquals(actualSecondCustomerPostCode, DataFile.SECOND_CUSTOMER_POSTCODE.data);
        Assert.assertEquals(secondCustomerAccountNumber, expectedSecondCustomerAccountNumber);
    }


    @Test
    public void customerLogin(ITestContext context) {
        //Customer Login
        bankingLoginPage.clickHomePageButton();
        bankingLoginPage.clickCustomerLoginButton();
        String firstCustomerUserName = (String) context.getAttribute("firstCustomerUserName");
        bankingCustomerPage.selectNameFromDropdown(firstCustomerUserName);
        bankingCustomerPage.clickLoginButton();

        //Retrieving text from welcome page ui and asserting them
        String actualUsername = bankingAccountPage.getTextFromUiWelcomePage();
        firstCustomerUserName = (String) context.getAttribute("firstCustomerUserName");
        Assert.assertEquals(actualUsername, firstCustomerUserName);
        Integer actualAccountNumber = Integer.parseInt(bankingAccountPage.getTextFromUiAccountNumber());
        int firstCustomerAccountNumber = (int) context.getAttribute("firstCustomerAccountNumber");
        Assert.assertEquals(actualAccountNumber, firstCustomerAccountNumber, "Account number is not matched");
        String actualBalanceAccount = bankingAccountPage.getTextFromUiAccountBalance();
        Assert.assertEquals(actualBalanceAccount, DataFile.BALANCE_ACCOUNT.data);

        //Withdrawn while balance is 0 and asserting the error message
        String message = bankingAccountPage.withdrawMessageFromUi(DataFile.AMOUNT_TO_BE_WITHDRAWN.data);
        Assert.assertEquals(message, DataFile.FAILED_TRANSACTION_MESSAGE.data);

        //Depositing some amount and asserting the success message
        int balanceAmountBeforeDeposit = Integer.parseInt(bankingAccountPage.getTextFromUiAccountBalance());
        int depositAmount = Integer.parseInt(DataFile.DEPOSIT_AMOUNT.data);
        int expectedBalanceAfterDeposit = balanceAmountBeforeDeposit + depositAmount;
        String actualDepositMessage = bankingAccountPage.depositMessageFromUi(DataFile.DEPOSIT_AMOUNT.data);
        String expectedDepositMessage = DataFile.SUCCESS_DEPOSIT_MESSAGE.data;
        Assert.assertEquals(actualDepositMessage, expectedDepositMessage, "Deposit message not matched");
        int actualBalanceAfterDeposit = Integer.parseInt(bankingAccountPage.getTextFromUiAccountBalance());
        Assert.assertEquals(actualBalanceAfterDeposit, expectedBalanceAfterDeposit);

        //checking transaction details like amount and transaction type for deposit amount
        bankingTransactionListPage.clickTransactionButton();
        String[] transactionDetailsForDeposit = bankingTransactionListPage.getTransactionRow();
        String transactionAmountForDeposit = transactionDetailsForDeposit[5];
        Assert.assertEquals(transactionAmountForDeposit, DataFile.DEPOSIT_AMOUNT.data);
        String transactionTypeForDeposit = transactionDetailsForDeposit[6];
        Assert.assertEquals(transactionTypeForDeposit, DataFile.CREDIT_TRANSACTION_TYPE.data);

        //withdrawing some amount when balance is sufficient
        bankingTransactionListPage.clickBackButton();
        int withdrawAmountAfterDeposit = Integer.parseInt(DataFile.AMOUNT_TO_BE_WITHDRAWN.data);
        int currentBalanceAfterDeposit = Integer.parseInt(bankingAccountPage.getTextFromUiAccountBalance());
        String msg = bankingAccountPage.withdrawMessageFromUi(DataFile.AMOUNT_TO_BE_WITHDRAWN.data);
        if (withdrawAmountAfterDeposit > currentBalanceAfterDeposit) {
            Assert.assertEquals(msg, DataFile.FAILED_TRANSACTION_MESSAGE.data);
        } else {
            Assert.assertEquals(msg, DataFile.SUCCESS_TRANSACTION_MESSAGE.data);
        }

        //checking transaction details like amount and transaction type for withdrawn amount after deposit
        bankingTransactionListPage.clickTransactionButton();
        String[] transactionDetailsForWithdrawnAmount = bankingTransactionListPage.getTransactionRow();
        String transactionAmountForWithdrawn = transactionDetailsForWithdrawnAmount[5];
        String transactionTypeForWithdrawn = transactionDetailsForWithdrawnAmount[6];
        Assert.assertEquals(transactionAmountForWithdrawn, DataFile.AMOUNT_TO_BE_WITHDRAWN.data);
        Assert.assertEquals(transactionTypeForWithdrawn, DataFile.DEBIT_TRANSACTION_TYPE.data);
        bankingTransactionListPage.clickBackButton();
        int actualBalanceAccountAfterWithdrawn = Integer.parseInt(bankingAccountPage.getTextFromUiAccountBalance());
        int expectedBalanceAmountAfterWithdrawn = Integer.parseInt(transactionDetailsForDeposit[5]) - Integer.parseInt(transactionDetailsForWithdrawnAmount[5]);
        Assert.assertEquals(actualBalanceAccountAfterWithdrawn, expectedBalanceAmountAfterWithdrawn);
    }

    @Test
    public void deleteAccount() {
        //deleting the second customer and checking the both customers
        bankingLoginPage.clickHomePageButton();
        bankingLoginPage.clickBankManagerLoginButton();
        bankingManagerPage.clickCustomersButton();
        bankingManagerCustomersListPage.setSecondCustomerInSearchTextBox(DataFile.SECOND_CUSTOMER_FIRSTNAME.data);
        bankingManagerCustomersListPage.clickDeleteButton();

        //checking whether second customer is deleted or not
        Assert.assertFalse(bankingManagerCustomersListPage.checkCustomerAccount());

        //searching and checking the first customer details
        bankingManagerCustomersListPage.setFirstCustomerInSearchTextBox(DataFile.FIRST_CUSTOMER_FIRSTNAME.data);
        Assert.assertTrue(bankingManagerCustomersListPage.checkCustomerAccount());

    }
}



