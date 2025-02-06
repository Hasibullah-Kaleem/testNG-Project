package myapp.tests;

import myapp.pages.WhishListPage.WhishList_Page;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WhishListPage_US08 {


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
    }

    @Test
    public void US08_TC01() throws InterruptedException {
        System.out.println("US08_TC01 is running...");

        ExtentReportUtils.createTestReport("UI Test ,", "WhishList Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("Navigated to website");

        WhishList_Page whishlist_page = new WhishList_Page();

        ExtentReportUtils.pass("User is on the Home page");

        BrowserUtils.clickWithTimeOut(whishlist_page.smallHeart, 1);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the small heart icon");

        BrowserUtils.clickWithTimeOut(whishlist_page.bigHeart, 1);
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on the big heart icon");

        ExtentReportUtils.pass("User clicks on the big heart icon");

        Assert.assertTrue(whishlist_page.removeButton.isDisplayed());

        ExtentReportUtils.flush();

    }




    @Test
    public void US08_TC02() throws InterruptedException {
        System.out.println("US08_TC03 is running...");

        ExtentReportUtils.createTestReport("UI Test ,", "WhishList Page Test");

        WhishList_Page whishlist_page = new WhishList_Page();
        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("Navigated to website");
        ExtentReportUtils.pass("User is on the Home page");

        BrowserUtils.clickWithTimeOut(whishlist_page.smallHeart, 1);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the small heart icon");

        BrowserUtils.clickWithTimeOut(whishlist_page.bigHeart, 1);
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on the big heart icon");

        ExtentReportUtils.pass("User clicks on the big heart icon");
        Assert.assertTrue(whishlist_page.quickViewButton.isDisplayed());


        BrowserUtils.clickWithTimeOut(whishlist_page.quickViewButton, 1);
        Thread.sleep(2000);

        ExtentReportUtils.pass("User clicks on the quick view button");

        Assert.assertTrue(whishlist_page.wishListButtonInquickView.isDisplayed());


        ExtentReportUtils.flush();

    }


    @Test
    public void US08_TC03() throws InterruptedException {
        System.out.println("US08_TC04 is running...");

        ExtentReportUtils.createTestReport("UI Test ,", "WhishList Page Test");

        WhishList_Page whishlist_page = new WhishList_Page();
        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("Navigated to website");
        ExtentReportUtils.pass("User is on the Home page");

        BrowserUtils.clickWithTimeOut(whishlist_page.smallHeart, 1);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the small heart icon");

        BrowserUtils.clickWithTimeOut(whishlist_page.bigHeart, 1);
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on the big heart icon");

        ExtentReportUtils.pass("User clicks on the big heart icon");
        BrowserUtils.clickWithTimeOut(whishlist_page.addToCartButton, 1);
        Thread.sleep(2000);
            ExtentReportUtils.pass("User clicks on the add to cart button");
           BrowserUtils.clickWithTimeOut(whishlist_page.cartButton, 1);
        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the cart button");
        Thread.sleep(2000);
        Assert.assertTrue(whishlist_page.shoppingCart.isDisplayed());

        ExtentReportUtils.flush();
    }


    @AfterMethod
    public void tearDown() {
        // Close the driver
        Driver.closeDriver();

    }


}
