package com.persistent.register.api.tests;

import com.persistent.register.api.enums.Data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class UpdateEmployee extends Data {
    @Test
    public void updateEmployee() {
        String path = "/update/8";
        RestAssured.baseURI = baseUrl;
        RequestSpecification HTTPRequest = RestAssured.given();
        JSONObject json = new JSONObject();
        createEmployee("Suneetha", "15000", "23");
        Response response = HTTPRequest.put(path);
        HTTPRequest.header("Content-Type", "application/json");
        HTTPRequest.body(json.toJSONString());
        responseBody(response);
    }
}
