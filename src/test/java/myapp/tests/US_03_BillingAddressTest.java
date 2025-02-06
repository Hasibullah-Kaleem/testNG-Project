package myapp.tests;

import myapp.pages.accountPage.US_03_BillingAddressPage;
import myapp.utilities.Driver;
import myapp.utilities.MediaUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class US_03_BillingAddressTest {

    US_03_BillingAddressPage us_03_billingAddressPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        us_03_billingAddressPage = new US_03_BillingAddressPage();
        Driver.getDriver().get("https://allovercommerce.com");
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    private void signIn() throws IOException {
        us_03_billingAddressPage.signInButton.click();
        us_03_billingAddressPage.username.sendKeys("pelingursoytechpro@gmail.com");
        us_03_billingAddressPage.password.sendKeys("techproteam");
        us_03_billingAddressPage.signIn.click();

        // Take a screenshot before clicking Sign Out
        MediaUtils.takeScreenshotOfTheEntirePage();
        us_03_billingAddressPage.signOutButton.click();

        // Verify the user is redirected to the My Account page
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("my-account"), "Failed to redirect to My Account page.");
    }

    @Test
    public void positiveTest() throws IOException {
        // 1. Sign In
        signIn();

        // 2. Navigate to "Addresses" section and edit the form
        us_03_billingAddressPage.addressOption.click();
        us_03_billingAddressPage.editBillingAddressButton.click();

        // 3. Fill out the form with valid information
        us_03_billingAddressPage.billingFirstName.sendKeys("Sally");
        us_03_billingAddressPage.billingLastName.sendKeys("Smith");
        us_03_billingAddressPage.billingCompany.sendKeys("home office");
        us_03_billingAddressPage.streetAddress.sendKeys("5678 Ocean Drive");
        us_03_billingAddressPage.billingCity.sendKeys("Miami");
        us_03_billingAddressPage.billingState.sendKeys("Florida");
        us_03_billingAddressPage.billingPostcode.sendKeys("43017");
        us_03_billingAddressPage.billingPhone.sendKeys("+1 222 772007");
        us_03_billingAddressPage.billingEmail.sendKeys("sallysmith@abc.com");

        // 4. Save the address and verify the operation was successful
        us_03_billingAddressPage.saveButton.click();
        Assert.assertTrue(us_03_billingAddressPage.saveButton.isDisplayed(), "Save operation might have failed.");
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Test
    public void negativeTest() throws IOException {
        // 1. Sign In
        signIn();

        // 2. Navigate to "Addresses" section and edit the form
        us_03_billingAddressPage.addressOption.click();
        us_03_billingAddressPage.editBillingAddressButton.click();

        // 3. Negative scenario: Clear the First Name field
        us_03_billingAddressPage.billingFirstName.clear();

        // Fill in the other required fields
        us_03_billingAddressPage.billingFirstName.sendKeys();
        us_03_billingAddressPage.billingLastName.sendKeys("Smith");
        us_03_billingAddressPage.billingCompany.sendKeys("home office");
        us_03_billingAddressPage.streetAddress.sendKeys("5678 Ocean Drive");
        us_03_billingAddressPage.billingCity.sendKeys("Miami");
        us_03_billingAddressPage.billingPostcode.sendKeys("4301");

        // 4. Click the Save button and verify the error message
        us_03_billingAddressPage.saveButton.click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'First name is a required field')]")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed!");

        // Take a screenshot of the error message
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}