package com.persistent.register.common;

import com.persistent.register.ui.base.SeleniumMethods;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners  extends SeleniumMethods implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED test");
        System.out.println("Screenshot captured");
        System.out.println("Failure of test cases and its details are : " + result.getName());

    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Start of test cases and its details are : " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finish of test cases and its details are : " + context.getName());
    }
}
