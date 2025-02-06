package myapp.utilities;



/*
1. In utilities package, create a ListenersUtils class
Listeners class has all ITestListeners methods.
And implements ITestListeners interface. (This is like a TestBase class)
2. Implement ITestListener
3. Add the ITestListener Methods
———————————————-
4. In tests package, create a new package : listeners
5. In listeners package, create a new java class : ListenersTest
6. There are 2 ways to connect Listeners and Test Classes
 a. Use  this  in  the  test  class  :
		@Listeners(myapp.utilities.Listeners.class)

OR
b. Add listeners tagbefore test in the xml file to  connect Listeners and  this  xml  file
<listeners>
<listener class-name="techproed.utilities.Listeners"></listener>
</listeners>
 */


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtils implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        //BeforeSuite Annatotaion, like beforeAll

        System.out.println("onStart : executes only BEFORE ALL test " +context.getName());

    }


    @Override
    public void onFinish(ITestContext context) {

        //AfterAll anatotation

        System.out.println("onFinis : executes only once AFTER ALL test" +context.getName());



    }

    @Override
    public void onTestStart(ITestResult result) {

        //BeforeEach anatation

        System.out.println("onTestStart : executes only before each test " +result.getName());

    }


    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("OnTestSkipped : executes only when the test is skipped " +result.getName());

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