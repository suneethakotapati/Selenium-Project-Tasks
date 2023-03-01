package com.persistent.register.api.tests;

import com.persistent.register.api.base.Methods;
import com.persistent.register.api.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteEmployee extends Methods {
    /**
     * Specify the base URL to the RESTful web service
     * Get the RequestSpecification of the request to be sent to the server
     * receive the response from the server
     * deleting the particular employee
     */
    @Test
    public void deleteEmployeeById() {
        String path = baseUrl + DataFile.DELETE.data;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.delete(path);
        responseBody(response);
    }
}
