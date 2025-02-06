package myapp.tests;

import myapp.pages.ComparePage.Compare_Page;
import myapp.utilities.*;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComparePage_US07 {


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
    }

    @Test
    public void US07_TC01() throws InterruptedException {
        System.out.println("US07_TC01 is running...");


        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        Compare_Page comparePage = new Compare_Page();
        ActionsUtils actions = new ActionsUtils();

        ExtentReportUtils.pass("User is on the Home page");

        // comparePage.scaleIcon.click();

        BrowserUtils.clickWithTimeOut(comparePage.scaleIcon, 3);
        ExtentReportUtils.pass("User added the product to the compare page");
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("Product added to Compare list....");


        ActionsUtils.actionsDoubleClick(comparePage.centralPanel);
        // Scroll down using arrow keys
        ActionsUtils.actionsScrollDown();
        ExtentReportUtils.passAndCaptureScreenshot("User Scroll-down the page....");
        Thread.sleep(2000);


        ActionsUtils.actionsHoverOverOnElement(comparePage.procuct2);
        ExtentReportUtils.pass("User hover over the second product to add it to the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.scaleIcon3, 3);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User added the second product to the compare page");


        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");
        Thread.sleep(2000);

        //comparePage.startCompare.click();
        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");

        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");
        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User is in the compare page....");

        ExtentReportUtils.flush();
    }

    @Test
    public void US07_TC02() throws InterruptedException {
        System.out.println("US07_TC02 is running...");
        Compare_Page comparePage = new Compare_Page();

        ActionsUtils actions = new ActionsUtils();
        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        BrowserUtils.clickWithTimeOut(comparePage.searchBox, 3);
        ExtentReportUtils.pass("User clicks on the search box to search for a product");
        comparePage.searchBox.sendKeys("book");
        ExtentReportUtils.pass("User searches for a product");
        comparePage.searchBox.submit();
        ExtentReportUtils.pass("User submits the search");
        ExtentReportUtils.passAndCaptureScreenshot("User is seeing the search results....");

        //  Thread.sleep(2000);

        //  Thread.sleep(1000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);
        Thread.sleep(1000);

        ActionsUtils.actionsHoverOverOnElement(comparePage.productImage1);
        Thread.sleep(1000);
        BrowserUtils.clickWithTimeOut(comparePage.addCompare1, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("First product added to the compare page....");
        Thread.sleep(2000);

        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);
        Thread.sleep(1000);

        ActionsUtils.actionsHoverOverOnElement(comparePage.priceProduct2);
        Thread.sleep(1000);
        BrowserUtils.clickWithTimeOut(comparePage.addCompare2, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");

        Thread.sleep(2000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);

        ActionsUtils.actionsHoverOverOnElement(comparePage.priceProduct3);
        Thread.sleep(1000);
        BrowserUtils.clickWithTimeOut(comparePage.addCompare3, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Third product added to the compare page....");

        Thread.sleep(2000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);

        ActionsUtils.actionsHoverOverOnElement(comparePage.productImage4);
        Thread.sleep(1000);
        BrowserUtils.clickWithTimeOut(comparePage.addCompare4, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Fourth product added to the compare page....");

        Thread.sleep(2000);


        //ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);


        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");

        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");
        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User is in the compare page....");
        ExtentReportUtils.flush();

    }

    @Test
    public void US07_TC03() throws InterruptedException {
        System.out.println("US07_TC03 is running...");
        Compare_Page comparePage = new Compare_Page();
        ActionsUtils actions = new ActionsUtils();

        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        ActionsUtils.actionsHoverOverOnElement(comparePage.menCategory);

        ExtentReportUtils.pass("User clicks on men category");
        BrowserUtils.clickWithTimeOut(comparePage.fashionCategory, 3);
        ExtentReportUtils.pass("User clicks on fashion category");

        ActionsUtils.actionsHoverOverOnElement(comparePage.productMen1);
        ExtentReportUtils.pass("User hover over the first product to add it to the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.scaleProductMen1, 3);
        ExtentReportUtils.pass("User added the first product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("First product added to the compare page....");
        Thread.sleep(2000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);

        ActionsUtils.actionsHoverOverOnElement(comparePage.productMen2);
        Thread.sleep(1000);
        ExtentReportUtils.pass("User hover over the second product to add it to the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.scaleProductMen2, 3);
        ExtentReportUtils.pass("User added the second product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");
        Thread.sleep(2000);


        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");

        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");
        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User is in the compare page....");
        ExtentReportUtils.flush();
    }

    @Test
    public void US07_TC04() throws InterruptedException {
        System.out.println("US07_TC04 is running...");
        Compare_Page comparePage = new Compare_Page();
        ActionsUtils actions = new ActionsUtils();

        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        BrowserUtils.clickWithTimeOut(comparePage.scaleIcon, 3);
        ExtentReportUtils.pass("User added the product to the compare page");
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("Product added to Compare list....");


        ActionsUtils.actionsDoubleClick(comparePage.centralPanel);
        // Scroll down using arrow keys
        ActionsUtils.actionsScrollDown();
        ExtentReportUtils.passAndCaptureScreenshot("User Scroll-down the page....");
        Thread.sleep(2000);


        ActionsUtils.actionsHoverOverOnElement(comparePage.procuct2);
        ExtentReportUtils.pass("User hover over the second product to add it to the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.scaleIcon3, 3);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User added the second product to the compare page");


        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");
        Thread.sleep(2000);

        //comparePage.startCompare.click();
        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");
        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");

        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");


        BrowserUtils.clickWithTimeOut(comparePage.removeProduct1, 3);
        ExtentReportUtils.pass("User removes the first product from the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("First product removed from the compare page....");
        Thread.sleep(1000);

        BrowserUtils.clickWithTimeOut(comparePage.removeProduct2, 3);
        ExtentReportUtils.pass("User removes the second product from the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Second product removed from the compare page....");
        Thread.sleep(1000);

        Assert.assertTrue(comparePage.noProductsAdded.isDisplayed());
        ExtentReportUtils.pass("User is seeing the no products added message in the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("No products added message is displayed....");


        ExtentReportUtils.flush();
    }


@AfterMethod
public void tearDown() {
    // Close the driver
    Driver.closeDriver();

}


}
