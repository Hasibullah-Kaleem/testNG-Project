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

public class US_13_Goychak {
    HomePage homePage;
    Login_Page loginPage;
    MyAccount_Page myAccountPage;
    ShippingAddressPage shippingAddressPage;
    Faker faker;

    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerce_url"));
        homePage = new HomePage();
        loginPage = new Login_Page();
        myAccountPage = new MyAccount_Page();
        shippingAddressPage = new ShippingAddressPage();
        faker = new Faker();

        homePage.signInOption.click();
        loginPage.usernameEmailInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("Password"));
        loginPage.signInButton.click();

        ActionsUtils.actionsScrollDown();
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(homePage.myAccountTab);
        myAccountPage.addressesMenuTab.click();
        WaitUtils.waitFor(3);
        ActionsUtils.actionsScrollDown();
        shippingAddressPage.editShippingAddress.click();
        WaitUtils.waitFor(5);

    }

    @Test
    public void test01() {

        shippingAddressPage.firstNameShipping.clear();
        shippingAddressPage.firstNameShipping.sendKeys(faker.name().firstName());
        shippingAddressPage.lastNameShipping.clear();
        shippingAddressPage.lastNameShipping.sendKeys(faker.name().lastName());

        BrowserUtils.dropdownSelectByVisibleText(shippingAddressPage.countryDropDownShipping, "Antarctica");
        WaitUtils.waitFor(3);
        shippingAddressPage.streetAddressShipping.clear();
        shippingAddressPage.streetAddressShipping.sendKeys(faker.address().fullAddress());
        shippingAddressPage.cityShipping.clear();
        shippingAddressPage.cityShipping.sendKeys(faker.address().city());
        WaitUtils.waitFor(3);

        // State Field
            WaitUtils.waitForVisibility(shippingAddressPage.stateShipping, 1);
            if (shippingAddressPage.stateShipping.isDisplayed()) {
                shippingAddressPage.stateShipping.clear();
                shippingAddressPage.stateShipping.sendKeys(faker.address().state());
                System.out.println("State entered successfully!");
            } else {
                System.out.println("State field not visible, continuing...");
            }


        // Zip Code
            WaitUtils.waitForVisibility(shippingAddressPage.zipCodeShipping, 1);
            if (shippingAddressPage.zipCodeShipping.isDisplayed()) {
                shippingAddressPage.zipCodeShipping.clear();
                shippingAddressPage.zipCodeShipping.sendKeys(faker.address().zipCode());
                System.out.println("Zip Code entered successfully!");
            } else {
                System.out.println("Zip Code field not visible, continuing...");
            }
        ActionsUtils.actionsHoverOverOnElement(shippingAddressPage.saveAddressButton);

        shippingAddressPage.saveAddressButton.click();
        WaitUtils.waitFor(3);

        assertEquals("Address changed successfully.", shippingAddressPage.addressSuccessfullyChangedAlert.getText());
        WaitUtils.waitFor(3);


    }

    @Test
    public void test02() {
        shippingAddressPage.firstNameShipping.clear();
        shippingAddressPage.firstNameShipping.sendKeys(faker.name().firstName());

        // Omitting Last Name
        shippingAddressPage.lastNameShipping.clear();

        BrowserUtils.dropdownSelectByVisibleText(shippingAddressPage.countryDropDownShipping, "Antarctica");
        WaitUtils.waitFor(3);

        // Omitting Street Address
        shippingAddressPage.streetAddressShipping.clear();

        // Omitting City
        shippingAddressPage.cityShipping.clear();

        // State Field
        WaitUtils.waitForVisibility(shippingAddressPage.stateShipping, 1);
        if (shippingAddressPage.stateShipping.isDisplayed()) {
            shippingAddressPage.stateShipping.clear();
            shippingAddressPage.stateShipping.sendKeys(faker.address().state());
            System.out.println("State entered successfully!");
        } else {
            System.out.println("State field not visible, continuing...");
        }

        // Omitting Zip Code
        shippingAddressPage.zipCodeShipping.clear();

        ActionsUtils.actionsHoverOverOnElement(shippingAddressPage.saveAddressButton);
        shippingAddressPage.saveAddressButton.click();
        WaitUtils.waitFor(3);

        assertEquals(shippingAddressPage.incorrectLastName.getText(), "Last name is a required field.");
        assertEquals(shippingAddressPage.incorrectStreetAddress.getText(), "Street address is a required field.");
        assertEquals(shippingAddressPage.incorrectCity.getText(), "Town / City is a required field.");
        assertEquals(shippingAddressPage.incorrectZip.getText(), "Postcode / ZIP is a required field.");

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
