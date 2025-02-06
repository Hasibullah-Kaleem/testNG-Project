package myapp.tests;

import myapp.pages.HomePage;
import myapp.pages.RegistrationPage;
import myapp.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US_02_Natalia_T {

//  US_02: It is not possible to register on the site with previously registered information. (Register)

//      TC_01: Verify the user cannot register on the website with previously registered email
//      Given user is on the application home page https://allovercommerce.com/
//      Then clicks on Register option
//      Then enters not previously registered Username: from Fake class
//      Then enters previously registered Email: nataliatest1@gmail.com
//      Then enters valid Password: from Fake class
//      Then puts a tick in the privacy policy checkbox
//      Then clicks on Sign Up button
//      Then verify the registration is not successful:
//          (User sees warning message: "An account is already registered with your email address."
//          and "Please log in." message
//          and still on the registration page)

//      TC_02: Verify the user cannot register on the website with previously registered username
//      Given user is on the application home page https://allovercommerce.com/
//      Then clicks on Register option
//      Then enters previously registered Username: NataliaTest3
//      Then enters not previously registered Email: from Fake class
//      Then enters valid Password: from Fake class
//      Then puts a tick in the privacy policy checkbox
//      Then clicks on Sign Up button
//      Then verify the registration is not successful:
//          (User sees warning message: "An account is already registered with that username. Please choose another."
//          and still on the registration page)

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeMethod
    public void setUp(){
        String baseUrl = ConfigReader.getProperty("allOverCommerce_url");

//      Start Test Report
        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_02","Testing the registration functionality");

//      Navigate to home page https://allovercommerce.com/
        Driver.getDriver().get(baseUrl);
        ExtentReportUtils.pass("User navigated to " + baseUrl);

//      Wait for Register option and Click
        WaitUtils.waitForVisibility(homePage.registerOption, 5);
        homePage.registerOption.click();
        ExtentReportUtils.pass("User clicked on Register option");
    }

//      Utility Method to Fill Registration Form
    private void fillRegistrationForm(String username, String email, String password) {
        registrationPage.regUserNameInput.sendKeys(username);
        ExtentReportUtils.pass("User entered Username: " + username);

        registrationPage.regEmailInput.sendKeys(email);
        ExtentReportUtils.pass("User entered Email: " + email);

        registrationPage.regPasswordInput.sendKeys(password);
        ExtentReportUtils.pass("User entered Password: " + password);

        registrationPage.registerPolicy.sendKeys(Keys.SPACE);
        ExtentReportUtils.pass("User checked the privacy policy checkbox");

        registrationPage.signUpButton.click();
        ExtentReportUtils.pass("User clicked on Sign Up button");
    }

//      TC_01: Verify the user cannot register on the website with previously registered email
    @Test
    public void testRegistrationFailsWithExistingEmail(){
//      Create test data
        String username = FakeDataUtils.getFakeUsername();
        String registeredEmail = "nataliatest1@gmail.com";
        String password = FakeDataUtils.getFakePassword();

        fillRegistrationForm(username, registeredEmail, password);

//      Verify the registration is not successful:
//          (User sees a warning message: "An account is already registered with your email address."
//          and "Please log in." message and still on the registration page)
//      Validate Error Messages
        assertEquals(registrationPage.regEmailWarningMsg.getText(), "An account is already registered with your email address. Please log in.",
                "Incorrect email warning message!");
        ExtentReportUtils.pass("User sees a warning message");

        assertEquals(registrationPage.pleaseLogInMsg.getText(), "Please log in.",
                "Incorrect 'Please log in' message!");
        ExtentReportUtils.pass("User sees a Please log in. message");

//      Verify User is Still on the Registration Page
        assertTrue(registrationPage.signUpButton.isDisplayed(), "User is NOT on the registration page!");
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page");

        ExtentReportUtils.info("Registration with existing email is not successful (expected behavior)");
    }

//      TC_02: Verify the user cannot register on the website with previously registered username
    @Test
    public void testRegistrationFailsWithExistingUsername(){
//      Create test data
        String registeredUsername = "NataliaTest3";
        String email = FakeDataUtils.getFakeEmail();
        String password = FakeDataUtils.getFakePassword();

        fillRegistrationForm(registeredUsername, email, password);

//      Verify the registration is not successful:
//          (User sees warning message: "An account is already registered with that username. Please choose another."
//          and still on the registration page)
//      Validate Warning Message
        assertEquals(registrationPage.regUsernameWarningMsg.getText(), "An account is already registered with that username. Please choose another.",
                "Incorrect username warning message!");
        ExtentReportUtils.pass("User sees a warning message");

//      Verify User is Still on the Registration Page
        assertTrue(registrationPage.signUpButton.isDisplayed(), "User is NOT on the registration page!");
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page");

        ExtentReportUtils.info("Registration with existing username is not successful (expected behavior)");
    }

    @AfterTest
    public void tearDown(){
        ExtentReportUtils.flush();   // Generate test report
        Driver.closeDriver();
    }
}
