package com.persistent.register.api.base;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class Methods extends BaseClass {
    /**
     *JSONObject is a class that represents a Simple JSON.
     *We can add Key - Value pairs using the put method
     * @param name
     * @param salary
     * @param age
     */
    public void createEmployee(String name, String salary, String age) {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("salary", salary);
        json.put("age", age);
    }

    /**
     * This method is used to get status-code,status line,response body
     * Assert the correct status code is returned.
     * @param response
     */
    public void responseBody(Response response) {
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        Assert.assertEquals(statusCode, 200, "Correct status code returned");

    }
}
