package com.persistent.register.api.tests;

import com.persistent.register.api.enums.Data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostEmployee extends Data {
    @Test
    public void postEmployee() {
        String path = "/create";
        RestAssured.baseURI = baseUrl;
        RequestSpecification HTTPRequest = RestAssured.given();
        JSONObject json = new JSONObject();
        createEmployee("harini", "16789", "23");
        Response response = HTTPRequest.post(path);
        HTTPRequest.header("Content-Type", "application/json");
        HTTPRequest.body(json.toJSONString());
        responseBody(response);

    }
}
