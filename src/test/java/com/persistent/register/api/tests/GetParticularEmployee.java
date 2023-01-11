package com.persistent.register.api.tests;

import com.persistent.register.api.base.BaseClass;
import com.persistent.register.api.base.Methods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetParticularEmployee extends Methods {
    @Test
    public void getEmployeeById(){
        String path = "/employee/7";
        RestAssured.baseURI = baseUrl;
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.get(path);
        responseBody(response);
    }
}