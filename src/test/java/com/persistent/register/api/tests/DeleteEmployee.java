package com.persistent.register.api.tests;

import com.persistent.register.api.enums.Data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteEmployee extends Data {
    @Test
    public void deleteEmployeeById(){
        String path = "/delete/9";
        RestAssured.baseURI = baseUrl;
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.delete(path);
        responseBody(response);
    }
}
