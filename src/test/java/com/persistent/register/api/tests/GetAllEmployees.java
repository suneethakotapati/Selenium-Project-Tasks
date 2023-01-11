package com.persistent.register.api.tests;

import com.persistent.register.api.base.Methods;
import com.persistent.register.api.base.BaseClass;
import com.persistent.register.api.enums.Data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetAllEmployees extends Data {
    @Test
    public void getEmployees(){
        String path = "/employees";
        RestAssured.baseURI = baseUrl;
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.get(path);
        responseBody(response);

    }


}
