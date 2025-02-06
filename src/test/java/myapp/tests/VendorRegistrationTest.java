package myapp.tests;

import myapp.pages.vendorRegistrationPage.VendorRegistrationPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class VendorRegistrationTest {

    VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();


    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }
    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        vendorRegistrationPage.registerOption.click();
        vendorRegistrationPage.signupAsVendorOption.click();
        vendorRegistrationPage.emailAddressInputBox.sendKeys("pelingursoytechpro@gmail.com");
        vendorRegistrationPage.verificationCodeInputBox.sendKeys(" ");
        //vendorRegistrationPage.reSendCodeButton.click();
        vendorRegistrationPage.passwordInputBox.sendKeys("Pgpelin123!");
        vendorRegistrationPage.confirmPasswordInputBox.sendKeys("Pgpelin123!");
        vendorRegistrationPage.registerButton.click();
        softAssert.assertTrue(driver.getTitle().equals("Dashboard"));
        softAssert.assertAll();
    }

    @Test
    public void test2() {
        SoftAssert softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        vendorRegistrationPage.registerOption.click();
        vendorRegistrationPage.signupAsVendorOption.click();
        vendorRegistrationPage.emailAddressInputBox.sendKeys("pelingursoytechpro@gmail.com");
        vendorRegistrationPage.verificationCodeInputBox.sendKeys();
        //vendorRegistrationPage.reSendCodeButton.click();
        vendorRegistrationPage.passwordInputBox.sendKeys("Pgpelin123!");
        vendorRegistrationPage.confirmPasswordInputBox.sendKeys("Pgpelin123!");
        vendorRegistrationPage.registerButton.click();
        softAssert.assertTrue(driver.getTitle().equals("Dashboard"));
        softAssert.assertAll();
    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        vendorRegistrationPage.registerOption.click();
        vendorRegistrationPage.signupAsVendorOption.click();
        vendorRegistrationPage.passwordInputBox.sendKeys("1234");


    }

    @Test
    public void test4(){
        SoftAssert softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        vendorRegistrationPage.registerOption.click();
        vendorRegistrationPage.signupAsVendorOption.click();
        vendorRegistrationPage.passwordInputBox.sendKeys("1234");
        vendorRegistrationPage.passwordInputBox.sendKeys("abc123");
        vendorRegistrationPage.passwordInputBox.sendKeys("Abc123");
        vendorRegistrationPage.passwordInputBox.sendKeys("Abc123!");

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
