package myapp.tests;

import myapp.pages.accountPage.US_03_BillingAddressPage;
import myapp.utilities.Driver;
import myapp.utilities.MediaUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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


//      1- User should navigate to "https://allovercommerce.com
      Driver.getDriver().get("https://allovercommerce.com");
      wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

   }


   @Test
   public void  positiveTest() throws IOException, InterruptedException {


      //User clicks on the Sign In button on the top right of the page.User is redirected to the Sign In page.
      us_03_billingAddressPage.signInButton.click();

      // User enters valid Username or Email and Password, then clicks Sign In.
      us_03_billingAddressPage.username.sendKeys("pelingursoytechpro@gmail.com");
      us_03_billingAddressPage.password.sendKeys("techproteam");
      us_03_billingAddressPage.signIn.click();

      // User clicks on the Sign Out and then redirected to the MyAccount page
      us_03_billingAddressPage.signOutButton.click();
      Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("my-account"),
              "Failed to redirect to the My Account page.");

      MediaUtils.takeScreenshotOfTheEntirePage();

      // User clicks  on  "Addresses" option
      us_03_billingAddressPage.addressOption.click();

      // us_03_billingAddressPage.billingFirstName.sendKeys("Sally");
      us_03_billingAddressPage.billingLastName.sendKeys("Smith");
      us_03_billingAddressPage.billingCompany.sendKeys("home office");


     // User enters valid Country, Street Address, Town/City, State, ZIP Code.,
             // phone and email address

      us_03_billingAddressPage.streetAddress.sendKeys("5678 Ocean Drive");
      us_03_billingAddressPage.billingCity.sendKeys("Miami");
      us_03_billingAddressPage.billingState.sendKeys("Florida");
      us_03_billingAddressPage.billingPostcode.sendKeys("43017");
      us_03_billingAddressPage.billingPhone.sendKeys("+1 222 772007");
      us_03_billingAddressPage.billingEmail.sendKeys("sallysmith@abc.com");
      us_03_billingAddressPage.editBillingAddressButton.click();

      us_03_billingAddressPage.saveButton.click();

   }

  @Test

  public void negativeTest(){

        // Navigate to the website
       Driver.getDriver().get("https://allovercommerce.com");

     // Click on the Sign In button
         us_03_billingAddressPage.signInButton.click();
         // Enter valid credentials and Sign In
        us_03_billingAddressPage.username.sendKeys("pelingursoytechpro@gmail.com");
        us_03_billingAddressPage.password.sendKeys("techproteam");us_03_billingAddressPage.signIn.click();

        // Click on the Addresses option
        us_03_billingAddressPage.addressOption.click();

         // Click on the Edit Billing Address button
         us_03_billingAddressPage.editBillingAddressButton.click();

        // Negative scenario: Clear the First Name field to leave it blank
        us_03_billingAddressPage.billingFirstName.clear();
        // Fill in the other required fields
         us_03_billingAddressPage.billingLastName.sendKeys("Smith");
         us_03_billingAddressPage.billingCompany.sendKeys("home office");
         us_03_billingAddressPage.streetAddress.sendKeys("5678 Ocean Drive");
        us_03_billingAddressPage.billingCity.sendKeys("Miami");
         us_03_billingAddressPage.billingPostcode.sendKeys("43017");
        // Click the Save button
        us_03_billingAddressPage.saveButton.click();

        // Verify the error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'First name is a required field')]")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed!");
     }










   }


