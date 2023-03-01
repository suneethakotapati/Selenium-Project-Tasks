package com.persistent.register.api.tests;

import com.persistent.register.api.base.Methods;
import com.persistent.register.api.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.persistent.register.common.Listeners.class)

public class GetAllEmployees extends Methods {
    /**
     * Specify the base URL to the RESTful web service
     * Get the RequestSpecification of the request to be sent to the server
     * receive the response from the server
     * Get all the employees data
     */
    @Test
    public void getEmployees() {
        String path = baseUrl + DataFile.GETALLEMPLOYEES.data;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.get(path);
        responseBody(response);

    }


}
