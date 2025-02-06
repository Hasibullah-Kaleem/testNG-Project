package myapp.tests;

import myapp.pages.HomePage;
import myapp.pages.RegistrationPage;
import myapp.utilities.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class US_01_Natalia_T {

//  US_01: It should be possible to register as a user (Customer) on the site. (Register)

//      TC_01: Verify the user can register on the website with valid credentials
//      Given user is on the application home page https://allovercommerce.com/
//      Then clicks on Register option
//      Then enters not previously registered Username: from Fake class
//      Then enters not previously registered Email: from Fake class
//      Then enters valid Password: from Fake class
//      Then puts a tick in the privacy policy checkbox
//      Then clicks on Sign Up button
//      Then verify the registration is successful: (User sees a success message and is redirected to the home page)

//      TC_02: Verify the user can't register on website with invalid email format
//      Given user is on the application home page https://allovercommerce.com/
//      Then clicks on Register option
//      Then enters not previously registered Username: from Fake class
//      Then enters the Email in invalid format: test
//      Then enters valid Password: from Fake class
//      Then puts a tick in the privacy policy checkbox
//      Then clicks on Sign Up button
//      Then verify the registration is not successful: (User sees a warning message and still on the registration page)

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    String username, email, password;

    @BeforeMethod
    public void setUp(){
        String baseUrl = ConfigReader.getProperty("allOverCommerce_url");

//      Start Test Report
        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_01","Testing the registration functionality");

//      Navigate to home page https://allovercommerce.com/
        Driver.getDriver().get(baseUrl);
        ExtentReportUtils.pass("User navigated to " + baseUrl);

//      Wait for Register option and Click
        WaitUtils.waitForVisibility(homePage.registerOption, 5);
        homePage.registerOption.click();
        ExtentReportUtils.pass("User clicked on Register option");
    }

    private void setupTestData(boolean validEmail){
        username = FakeDataUtils.getFakeUsername();
        email = validEmail ? FakeDataUtils.getFakeEmail() : "test"; // Use invalid email if false
        password = FakeDataUtils.getFakePassword();
    }

//      TC_01: Verify the user can register on the website with valid credentials
    @Test
    public void testSuccessfulRegistration() throws InterruptedException {
//      Create test data with valid Email
        setupTestData(true);

//      Enter not previously registered Username
        registrationPage.regUserNameInput.sendKeys(username);
        ExtentReportUtils.pass("User entered Username: " + username);

//      Enter not previously registered Email
        registrationPage.regEmailInput.sendKeys(email);
        ExtentReportUtils.pass("User entered Email: " + email);

//      Enter valid Password
        registrationPage.regPasswordInput.sendKeys(password);
        ExtentReportUtils.pass("User entered Password: " + password);

//      Put a tick in the privacy policy checkbox
        registrationPage.registerPolicy.sendKeys(Keys.SPACE);
        ExtentReportUtils.pass("User checked the privacy policy checkbox");

//      Click on Sign Up button
        registrationPage.signUpButton.click();
        ExtentReportUtils.pass("User clicked on Sign Up button");

//      Verify the registration is successful: (User sees success message and is redirected to the home page)
//      Ensure success message is displayed
        assertTrue(registrationPage.regSuccessMsg.isDisplayed(), "Success message is not displayed!");
        ExtentReportUtils.passAndCaptureScreenshot("User sees success message");

//      Ensure user is on the home page
        WaitUtils.waitForVisibility(homePage.signOutOption, 5);
        assertTrue(homePage.signOutOption.isDisplayed(), "User was not redirected to the homepage!");
        ExtentReportUtils.passAndCaptureScreenshot("User is redirected to the home page");

        ExtentReportUtils.info("Registration with valid credentials is successful (expected behavior)");
    }

//      TC_02: Verify the user can't register on website with invalid email format
    @Test
    public void testInvalidEmailRegistration(){
//      Create test data with invalid Email
        setupTestData(false);

//      Enter not previously registered Username
        registrationPage.regUserNameInput.sendKeys(username);
        ExtentReportUtils.pass("User entered Username: " + username);

//      Enter invalid Email
        registrationPage.regEmailInput.sendKeys(email);
        ExtentReportUtils.pass("User entered Invalid Email: " + email);

//      Enter valid Password
        registrationPage.regPasswordInput.sendKeys(password);
        ExtentReportUtils.pass("User entered Password: " + password);

//      Put a tick in the privacy policy checkbox
        registrationPage.registerPolicy.sendKeys(Keys.SPACE);
        ExtentReportUtils.pass("User checked the privacy policy checkbox");

//      Click on Sign Up button
        registrationPage.signUpButton.click();
        ExtentReportUtils.pass("User clicked on Sign Up button");

//      Verify the registration is not successful: (User sees a warning message and still on the registration page)
//      Ensure the warning message is displayed
//      Use JavaScript to get the validation message
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
                registrationPage.regEmailInput);

        // Verify the validation message
        assertEquals(validationMessage, "Please include an '@' in the email address. 'test' is missing an '@'.",
                "Validation message does not match expected text!");
        ExtentReportUtils.pass("User sees a warning message");

//      Ensure user is still on the registration page
        assertTrue(registrationPage.signUpButton.isDisplayed(), "User is NOT on the registration page!");
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page");

        ExtentReportUtils.info("Registration with invalid email format is not successful (expected behavior)");
    }

    @AfterTest
    public void tearDown(){
        ExtentReportUtils.flush();   // Generate test report
        Driver.closeDriver();
    }
}
