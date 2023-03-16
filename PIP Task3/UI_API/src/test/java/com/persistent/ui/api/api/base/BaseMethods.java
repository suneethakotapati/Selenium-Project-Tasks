package com.persistent.ui.api.api.base;

import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * This method contains URL of API for HTTP methods
 */
public abstract class BaseMethods {
    public String baseUrl="https://restful-booker.herokuapp.com";


    public abstract void onTestStart(ITestResult result);

    public abstract void onTestSuccess(ITestResult result);

    public abstract void onTestFailure(ITestResult result);

    public abstract void onStart(ITestContext context);

    public abstract void onFinish(ITestContext context);
}

