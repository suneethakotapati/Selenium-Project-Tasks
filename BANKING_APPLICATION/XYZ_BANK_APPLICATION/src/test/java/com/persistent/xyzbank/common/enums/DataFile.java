package com.persistent.xyzbank.common.enums;

/**
 * Enum data file is used to store and organize the locators (i.e., identifiers) for web elements on a web page
 */
public enum DataFile {
    URL("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"),
    FIRST_CUSTOMER_FIRSTNAME("sunitha"), FIRST_CUSTOMER_LASTNAME("Kota"), FIRST_CUSTOMER_POSTCODE("516434"),
    SECOND_CUSTOMER_FIRSTNAME("suma"), SECOND_CUSTOMER_LASTNAME("Rudi_reddy"), SECOND_CUSTOMER_POSTCODE("516411"),
    CURRENCY_VALUE("Rupee"),
    BALANCE_ACCOUNT("0"),
    AMOUNT_TO_BE_WITHDRAWN("200"),
    FAILED_TRANSACTION_MESSAGE("Transaction Failed. You can not withdraw amount more than the balance."),
    SUCCESS_TRANSACTION_MESSAGE("Transaction successful"),
    DEPOSIT_AMOUNT("1000"),
    SUCCESS_DEPOSIT_MESSAGE("Deposit Successful"),
    CREDIT_TRANSACTION_TYPE("Credit"),
    DEBIT_TRANSACTION_TYPE("Debit");

    /**
     * Fields
     */


    public final String data;


    /**
     * Constructor
     *
     * @param data to send data.
     */
    DataFile(String data) {
        this.data = data;
    }
}


