package com.persistent.register.api.tests;

import com.persistent.register.api.base.Methods;
import com.persistent.register.api.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostEmployee extends Methods {
    /**
     * Specify the base URL to the RESTful web service
     * Get the RequestSpecification of the request to be sent to the server
     * Add a header stating the Request body is a JSON
     * Add the Json to the body of the request
     * Post the request and check the response
     */
    @Test
    public void postEmployee() {
        String path = baseUrl + DataFile.POSTEMPLOYEE.data;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        JSONObject json = new JSONObject();
        createEmployee(DataFile.PostData.NAME.data1, DataFile.PostData.SALARY.data1, DataFile.PostData.AGE.data1);
        Response response = HTTPRequest.post(path);
        HTTPRequest.header("Content-Type", "application/json");
        HTTPRequest.body(json.toJSONString());
        responseBody(response);

    }
}
