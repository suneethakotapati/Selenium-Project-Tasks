package com.persistent.ui.api.api.base;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class Methods extends BaseMethods {

    public int returnResponseCode(Response response) {
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();
        return statusCode;

    }

    public String returnResponseBody(Response response) {
        ResponseBody body = response.getBody();
        String responseBody = body.asString();
        return responseBody;
    }

    public JSONObject createBookingBody(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn, String checkOut, String additionalNeeds) {
        JSONObject json = new JSONObject();
        json.put("firstname", firstName);
        json.put("lastname", lastName);
        json.put("totalprice", totalPrice);
        json.put("depositpaid", depositPaid);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin",checkIn);
        bookingDates.put("checkout",checkOut);
        json.put("bookingdates",bookingDates);
        json.put("additionalneeds",additionalNeeds);
        return json;
    }
    public JSONObject createTokenBody(String userName,String passWord){
        JSONObject json = new JSONObject();
        json.put("username",userName);
        json.put("password",passWord);
        return json;
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
