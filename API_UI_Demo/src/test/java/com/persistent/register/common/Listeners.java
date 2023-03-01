package com.persistent.register.common;

import com.persistent.register.ui.base.BasePage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  extends BasePage implements ITestListener {

    /**
     * This method will run on test start
     * @param result the partially filled <code>ITestResult</code>
     */
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start of test cases and its details are : " + result.getName());
    }

    /**
     * This method will run on test success
     * @param result <code>ITestResult</code> containing information about the run test
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : " + result.getName());
    }

    /**
     * This method will run on test failure
     * @param result <code>ITestResult</code> containing information about the run test
     */

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED test");
        System.out.println(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
        captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
        //captureScreenshot("test.png");
        System.out.println("Screenshot captured");
        System.out.println("Failure of test cases and its details are : " + result.getName());

    }

    /**
     * This method will run on start of test
     * @param context The test context
     */


    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Start of test cases and its details are : " + context.getName());
    }

    /**
     * This method will run on finish of test
     * @param context The test context
     */
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finish of test cases and its details are : " + context.getName());
    }
}
