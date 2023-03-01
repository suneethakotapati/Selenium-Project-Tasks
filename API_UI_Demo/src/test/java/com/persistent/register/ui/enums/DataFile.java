package com.persistent.register.ui.enums;

public enum DataFile {
    LOGIN_URL("https://demoqa.com/automation-practice-form"), FIRSTNAME("suneetha"), LASTNAME("kotapati"), EMAIL("suneetha.gitamw@gmail.com"), PHONENUMBER("6305597254"), SUBJECT("Commerce"), PHOTO("C:\\demopic\\MicrosoftTeams-image.png"), ADDRESS("Hyderabad,indira nagar,gachibowli"), STATE("Haryana"), CITY("Panipat"), EXPECTED_TITLE("DEMOQA"), TITLE_WEBSITE("Titles of the website matches"), DOB("08 Jan 2002"),GENDER("female");

    /**
     * Fields
     */
    public String data;

    /**
     * Constructor
     *
     * @param
     */
    DataFile(String data) {
        this.data = data;

    }
}

