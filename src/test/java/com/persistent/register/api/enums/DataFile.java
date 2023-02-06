package com.persistent.register.api.enums;

public enum DataFile {
    DELETE("/delete/12"), GETALLEMPLOYEES("/employees"), GETSINGLEEMPLOYEE("/employee/21"), POSTEMPLOYEE("/create"), UPDATEEMPLOYEE("/update/8");

    public final String data;

    DataFile(String data) {

        this.data = data;
    }

    /**
     * This method will be used to post the data
     */
    public enum PostData {
        NAME("suneetha"), SALARY("29000"), AGE("23");
        public final String data1;

        PostData(String data1) {
            this.data1 = data1;
        }
    }

    /**
     * This method is used to Update the data
     */
    public enum UpdateData {
        Name("sujatha"), SALARY("30000"), AGE("20");

        public final String data2;

        UpdateData(String data2) {
            this.data2 = data2;
        }
    }


}


