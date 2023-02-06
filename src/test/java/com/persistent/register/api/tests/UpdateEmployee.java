package com.persistent.register.api.tests;

import com.persistent.register.api.base.Methods;
import com.persistent.register.api.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class UpdateEmployee extends Methods {
    /**
     * Get the RequestSpecification of the request to be sent to the server
     * Add a header stating the Request body is a JSON
     * Update the employee data to server
     */
    @Test
    public void updateEmployee() {
        String path = baseUrl + DataFile.UPDATEEMPLOYEE.data;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        JSONObject json = new JSONObject();
        createEmployee(DataFile.UpdateData.Name.data2, DataFile.UpdateData.SALARY.data2, DataFile.UpdateData.AGE.data2);
        Response response = HTTPRequest.put(path);
        HTTPRequest.header("Content-Type", "application/json");
        HTTPRequest.body(json.toJSONString());
        responseBody(response);
    }
}
