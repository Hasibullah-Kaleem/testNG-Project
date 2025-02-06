package myapp.tests;

import com.github.javafaker.Faker;
import myapp.pages.HomePage;
import myapp.pages.accountPage.Login_Page;
import myapp.pages.accountPage.MyAccount_Page;
import myapp.pages.accountPage.ShippingAddressPage;
import myapp.utilities.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/*
TC_01
1- Navigate to "https://allovercommerce.com/"
2- Click on the Sign In tab located in the top-right corner of the website.
3- Enter valid vendor credentials (Email & Password) in the login fields.
4- Click on the Sign-In button to log into the account.
5- Scroll to the footer of the page and click on My Account under the My Account section.
6- On the My Account page, click on the Addresses tab.
7- Click on the Edit your shipping address under the Shipping Address section.
8- Enter valid details in all required fields: (first name, last name, country, city...)
9- Click the Save Address button.
10- Assert that the confirmation message "Address changed successfully." appears.



TC_02
1- Navigate to "https://allovercommerce.com/"
2- Click on the Sign In tab located in the top-right corner of the website.
3- Enter valid vendor credentials (Email & Password) in the login fields.
4- Click on the Sign-In button to log into the account.
5- Scroll to the footer of the page and click on My Account under the My Account section.
6- On the My Account page, click on the Addresses tab.
7- Click on the Edit your shipping address under the Shipping Address section.
8- Enter incomplete details in the required fields (e.g., leave out the Street Address, City, or ZIP Code).
9- Click the Save Address button.
10- Assert that an appropriate error message is displayed (e.g., "ZIP Code is a required field.").

*/

public class US_13_Goychak {
    HomePage homePage;
    Login_Page loginPage;
    MyAccount_Page myAccountPage;
    ShippingAddressPage shippingAddressPage;
    Faker faker;

    @BeforeMethod
    public void setUp() {

        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_13", "Testing the functionality of updating the shipping address.");

        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("User navigated to the page.");

        homePage = new HomePage();
        loginPage = new Login_Page();
        myAccountPage = new MyAccount_Page();
        shippingAddressPage = new ShippingAddressPage();
        faker = new Faker();

        homePage.signInOption.click();

        ExtentReportUtils.pass("User clicked on Sign-In button.");

        loginPage.usernameEmailInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("Password"));
        loginPage.signInButton.click();

        ExtentReportUtils.pass("User entered valid credentials as a vendor.");

        ActionsUtils.actionsScrollDown();
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(homePage.myAccountTab);
        myAccountPage.addressesMenuTab.click();

        ExtentReportUtils.pass("User scrolled down to the footer of the page and clicked on My Account tab.");

        WaitUtils.waitFor(3);
        ActionsUtils.actionsScrollDown();
        shippingAddressPage.editShippingAddress.click();
        WaitUtils.waitFor(5);

        ExtentReportUtils.pass("User clicked on 'Edit Your Shipping Address' tab.");

    }

    @Test
    public void test01() {

        shippingAddressPage.firstNameShipping.clear();
        shippingAddressPage.firstNameShipping.sendKeys(faker.name().firstName());

        ExtentReportUtils.pass("User entered a valid name in the 'First Name' field.");

        shippingAddressPage.lastNameShipping.clear();
        shippingAddressPage.lastNameShipping.sendKeys(faker.name().lastName());

        ExtentReportUtils.pass("User entered a valid last name in the 'Last Name' field.");

        BrowserUtils.dropdownSelectByVisibleText(shippingAddressPage.countryDropDownShipping, "Antarctica");
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User selected 'Antarctica' from the Country dropdown.");

        shippingAddressPage.streetAddressShipping.clear();
        shippingAddressPage.streetAddressShipping.sendKeys(faker.address().fullAddress());

        ExtentReportUtils.pass("User entered a valid address in the 'Street address' field.");

        shippingAddressPage.cityShipping.clear();
        shippingAddressPage.cityShipping.sendKeys(faker.address().city());
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User entered a valid city in the 'City' field.");

        // State Field
            WaitUtils.waitForVisibility(shippingAddressPage.stateShipping, 1);
            if (shippingAddressPage.stateShipping.isDisplayed()) {
                shippingAddressPage.stateShipping.clear();
                shippingAddressPage.stateShipping.sendKeys(faker.address().state());
                System.out.println("State entered successfully!");
            } else {
                System.out.println("State field not visible, continuing...");
            }

        ExtentReportUtils.pass("User entered a valid State name in the 'State' field.");

        // Zip Code
            WaitUtils.waitForVisibility(shippingAddressPage.zipCodeShipping, 1);
            if (shippingAddressPage.zipCodeShipping.isDisplayed()) {
                shippingAddressPage.zipCodeShipping.clear();
                shippingAddressPage.zipCodeShipping.sendKeys(faker.address().zipCode());
                System.out.println("Zip Code entered successfully!");
            } else {
                System.out.println("Zip Code field not visible, continuing...");
            }

        ExtentReportUtils.pass("User entered a valid postcode code in the 'ZIP code' field.");

        ActionsUtils.actionsHoverOverOnElement(shippingAddressPage.saveAddressButton);

        shippingAddressPage.saveAddressButton.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on the 'Save Address' button.");

        assertEquals("Address changed successfully.", shippingAddressPage.addressSuccessfullyChangedAlert.getText());
        WaitUtils.waitFor(3);

        ExtentReportUtils.passAndCaptureScreenshot("User observes the success message.");
        ExtentReportUtils.info("Validation works as expected: The shipping address is successfully added when all required fields are completed.");
    }

    @Test
    public void test02() {
        shippingAddressPage.firstNameShipping.clear();
        shippingAddressPage.firstNameShipping.sendKeys(faker.name().firstName());

        ExtentReportUtils.pass("User entered a valid name in the 'First Name' field.");

        // Omitting Last Name
        shippingAddressPage.lastNameShipping.clear();

        ExtentReportUtils.info("User left the 'Last name' field empty.");

        BrowserUtils.dropdownSelectByVisibleText(shippingAddressPage.countryDropDownShipping, "Antarctica");
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User selected 'Antarctica' from the Country dropdown.");

        // Omitting Street Address
        shippingAddressPage.streetAddressShipping.clear();

        ExtentReportUtils.info("User left the 'Street address' field empty.");

        // Omitting City
        shippingAddressPage.cityShipping.clear();

        ExtentReportUtils.info("User left the 'City' field empty.");

        // State Field
        WaitUtils.waitForVisibility(shippingAddressPage.stateShipping, 1);
        if (shippingAddressPage.stateShipping.isDisplayed()) {
            shippingAddressPage.stateShipping.clear();
            shippingAddressPage.stateShipping.sendKeys(faker.address().state());
            System.out.println("State entered successfully!");
        } else {
            System.out.println("State field not visible, continuing...");
        }

        ExtentReportUtils.pass("User entered a valid State name in the 'State' field.");

        // Omitting Zip Code
        shippingAddressPage.zipCodeShipping.clear();

        ExtentReportUtils.info("User left the 'ZIP code' field empty.");

        ActionsUtils.actionsHoverOverOnElement(shippingAddressPage.saveAddressButton);
        shippingAddressPage.saveAddressButton.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on the 'Save Address' button.");

        assertEquals(shippingAddressPage.incorrectLastName.getText(), "Last name is a required field.");
        assertEquals(shippingAddressPage.incorrectStreetAddress.getText(), "Street address is a required field.");
        assertEquals(shippingAddressPage.incorrectCity.getText(), "Town / City is a required field.");
        assertEquals(shippingAddressPage.incorrectZip.getText(), "Postcode / ZIP is a required field.");

        ExtentReportUtils.passAndCaptureScreenshot("User observes multiple warning messages.");
        ExtentReportUtils.info("Validation works as expected: Validation works as expected: Updating the shipping address with empty required fields is unsuccessful.");

    }

    @AfterMethod
    public void tearDown() {
        ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}
