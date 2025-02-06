package myapp.tests;


import myapp.pages.accountPage.US_04_ShippingAddressPage;
import myapp.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_04_ShippingAddressTest {



  US_04_ShippingAddressPage us_04_shippingAddressPage;
    WebDriverWait wait;


    @BeforeMethod


    public void setUp() {
        us_04_shippingAddressPage = new US_04_ShippingAddressPage();

        //User should navigate to "https://allovercommerce.com

        Driver.getDriver().get("https://allovercommerce.com");
          wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    }
      @Test

       public void test(){

          wait.until(ExpectedConditions.elementToBeClickable(us_04_shippingAddressPage.signInButton)).click();





     // us_04_shippingAddressPage.signInButton.click();


        }




    }



