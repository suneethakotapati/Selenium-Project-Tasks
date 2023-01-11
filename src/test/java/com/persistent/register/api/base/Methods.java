package com.persistent.register.api.base;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Methods extends BaseClass{

    public void responseBody(Response response){
        int statusCode= response.getStatusCode();
        System.out.println(statusCode);
        ResponseBody body=response.getBody();
        System.out.println(body.asString());
        Assert.assertEquals(statusCode,200,"Correct status code returned");

    }


}
