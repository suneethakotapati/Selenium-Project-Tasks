package com.persistent.xyzbank.common.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Start of test cases and its details are : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart of test cases and its details are : " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish of test cases and its details are : " + context.getName());
    }
}

