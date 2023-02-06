package com.persistent.register.ui.enums;

public enum DataFile {
    LOGIN_URL("https://demoqa.com/automation-practice-form"), LOGIN_FIRSTNAME("suneetha"), LOGIN_LASTNAME("kotapati"), LOGIN_EMAIL("suneetha.gitamw@gmail.com"), LOGIN_MOBILENUMBER("6305597254"), LOGIN_YEAR("2002"), LOGIN_MONTH("December"), LOGIN_SUBJECT("Commerce"), LOGIN_PHOTO("C:\\demopic\\MicrosoftTeams-image.png"), LOGIN_ADDRESS("Hyderabad,indira nagar,gachibowli"), STATE("Haryana"), CITY("Panipat"), EXPECTED_TITLE("DEMOQA"), TITLE_WEBSITE("Titles of the website matches");

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

