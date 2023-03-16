package com.persistent.ui.api.common.enums;

public enum DataFile {
    URL("http://j2store.net/demo/"),
    QUANTITY("1"),
    BILLING_DETAILS_FIRSTNAME("sunitha"),
    BILLING_DETAILS_LASTNAME("kotapati"),
    //BILLING_DETAILS_EMAIL("sunitha114@gmail.com"),

    BILLING_DETAILS_PHONE("6305597254"),
    BILLING_DETAILS_MOBILE("8985283122"),
    BILLING_DETAILS_PASSWORD("suni@1234"),
    BILLING_DETAILS_CONFIRM_PASSWORD("suni@1234"),
    BILLING_DETAILS_COMPANY("Persistent"),
    BILLING_DETAILS_ADDRESS_LINE("3/64"),
    BILLING_DETAILS_CITY("Hyderabad"),
    BILLING_DETAILS_POSTCODE("516434"),
    COUNTRY("India"),
    ZONE("Andhra Pradesh"),
    SHIPPING_ADDRESS_FIRST_NAME("Suma"),
    SHIPPING_ADDRESS_LAST_NAME("Rudi_reddy"),
    SHIPPING_ADDRESS_MOBILE_NUMBER("8985283122"),
    SHIPPING_ADDRESS_LINE1("3/98"),
    SHIPPING_ADDRESS_CITY("Hyderabad"),
    SHIPPING_ADDRESS_POSTAL_CODE("516411"),
    CUSTOMER_NOTE_BOX("please keep package at the door"),
    DESTINATION_DROPDOWN_TEXT("Save as PDF"),
    INVOICES_PDF_FOLDER_PATH("C:\\Users\\Suneetha.Kotapati\\OneDrive - Vertex, Inc\\Documents\\Invoices pdf\\"),


   SUCCESS_STATUS_CODE("200"),
   BOOKING_ENDPOINT("/booking"),
    BOOKING_ID("/1"),
    FIRSTNAME("Jim"),
    LASTNAME("Brown"),
    TOTAL_PRICE("111"),
    DEPOSIT_PAID("true"),
    CHECK_IN("2018-01-01"),
    CHECK_OUT("2019-01-01"),
    ADDITIONAL_NEEDS("Breakfast"),
    AUTH_ENDPOINT("/auth"),
    USERNAME("admin"),
    PASSWORD("password123"),
    UPDATE_FIRSTNAME("James");












    public final String data;

    DataFile(String data) {
        this.data=data;
    }
}
