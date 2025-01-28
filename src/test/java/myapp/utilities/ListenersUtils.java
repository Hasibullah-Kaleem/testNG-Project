package myapp.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtils implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        //BeforeSuite Annatotaion, like beforeAll

        System.out.println("onStart : executes only BEFORE ALL test " + context.getName());

    }


    @Override
    public void onFinish(ITestContext context) {

        //AfterAll anatotation

        System.out.println("onFinis : executes only once AFTER ALL test" + context.getName());


    }

    @Override
    public void onTestStart(ITestResult result) {

        //BeforeEach anatation

        System.out.println("onTestStart : executes only before each test " + result.getName());

    }


    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("OnTestSkipped : executes only when the test is skipped " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("OnTestFailure : executes only after each failed test " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("OnTestSuccess : executes only after each passing test " + result.getName());

    }

//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//    }

}
