package myapp.tests;

import myapp.pages.accountPage.US_03_BillingAddressPage;
import myapp.utilities.Driver;

import myapp.utilities.MediaUtils;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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


//      "9- User enters valid Country, Street Address, Town/City, State, ZIP Code.,
//      phone and email address"
//      10- User clicks on 'Save Address' button.
//      "11-System displays 'Address saved successfully and the new address
//      is visible under the Billing Address section."

   }


   @Test
   public void test() throws IOException, InterruptedException {


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

      //      6-User clicks  on  "Addresses" option
      us_03_billingAddressPage.addressOption.click();


   }
}


