package myapp.tests;

import myapp.pages.AddProduct_Page;
import myapp.pages.HomePage;
import myapp.pages.StoreManager_Page;
import myapp.pages.accountPage.Login_Page;
import myapp.pages.accountPage.MyAccount_Page;
import myapp.utilities.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
TC_01
1- Navigate to https://allovercommerce.com/
2- Click on the Sign In tab located in the top-right corner of the website.
3- Enter valid vendor credentials (Email & Password) in the login fields.
4- Click on the Sign-In button to log into the account.
5- Scroll to the footer of the page and click on My Account under the My Account section.
6- Click on the Store Manager tab on the left-hand side of the website.
7- Hover on the Products tab on the left-hand side of the website.
8- Click on the Add New tab on the right.
9- Enter valid details in all required fields: (Product Title, Short Description and Full Description, Categories, Product Brands, Images...)
10- Click on the Submit button in the bottom-right corner of the page.
11- Assert that the confirmation message "Product successfully published."

TC_02
1- Navigate to https://allovercommerce.com/
2- Click on the Sign In tab located in the top-right corner of the website.
3- Enter valid vendor credentials (Email & Password) in the login fields.
4- Click on the Sign-In button to log into the account.
5- Scroll to the footer of the page and click on My Account under the My Account section.
6- Click on the Store Manager tab on the left-hand side of the website.
7- Hovers on the Products tab on the left-hand side of the website.
8- Click on the Add New tab on the right.
9- Enter valid details in some fields and leave one or more required fields empty, such as: Product Title, Short Description and Full Description, Categories, Product Brands, Images
10- Click on the Submit button in the bottom-right corner of the page.
11- Assert that the system displays an error message, such as: "Gallery Images: This field is required; Please insert Product Title before submit; Product cat: This field is required."

*/

public class US_14_Goychak {
    HomePage homePage;
    Login_Page loginPage;
    MyAccount_Page myAccountPage;
    StoreManager_Page storeManagerPage;
    AddProduct_Page addProductPage;

    Robot robot;
    String pathOfImage1 = "C:\\Users\\KM\\Desktop\\shirts\\redshirt.png";
    String pathOfImage2 = "C:\\Users\\KM\\Desktop\\shirts\\shirt.png";
    //String imagePath1 = System.getProperty("user.dir") + "/src/test/resources/redshirt.png";
    //String imagePath2 = System.getProperty("user.dir") + "/src/test/resources/shirt.png";

    @BeforeMethod
    public void setUp() throws AWTException {

        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_14", "Testing the Adding New Product functionality");

        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("User navigated to the page.");

        homePage = new HomePage();
        loginPage = new Login_Page();
        myAccountPage = new MyAccount_Page();
        storeManagerPage = new StoreManager_Page();
        addProductPage = new AddProduct_Page();
        robot = new Robot();

        homePage.signInOption.click();

        ExtentReportUtils.pass("User clicked on Sign-In button.");

        loginPage.usernameEmailInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("Password"));
        loginPage.signInButton.click();

        ExtentReportUtils.pass("User entered valid credentials as a vendor.");

        ActionsUtils.actionsScrollDown();
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(homePage.myAccountTab);

        ExtentReportUtils.pass("User scrolled down to the footer of the page and clicked on My Account tab.");

        myAccountPage.storeManagerMenuTab.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on Store Manager tab.");

        ActionsUtils.actionsHoverOverOnElement(storeManagerPage.productsMenuTab);
        storeManagerPage.addNew.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User hovered over the Products tab and clicked on Add New tab.");

    }

    @Test
    public void test01() throws AWTException {

        BrowserUtils.dropdownSelectByIndex(addProductPage.productTypeDropdown, 0);

        ExtentReportUtils.pass("User selected Simple Product option.");

        //Adding image
        addProductPage.addImage1.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on Add Image box.");

        addProductPage.selectImage1.click();
        WaitUtils.waitFor(3);

        robot.delay(2000);
        StringSelection selection = new StringSelection(pathOfImage1);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WaitUtils.waitFor(8);
        addProductPage.selectPastedImage.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User added first image to the gallery.");

        //Adding image to the gallery
        ActionsUtils.actionsHoverOverOnElement(addProductPage.addImage2);
        addProductPage.addImage2.click();

        ExtentReportUtils.pass("User clicked on a second Add Image box.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.uploadImageTab);
        WaitUtils.waitFor(3);
        addProductPage.uploadImageTab.click();
        addProductPage.selectImage2.click();
        WaitUtils.waitFor(2);
        StringSelection selection2 = new StringSelection(pathOfImage2);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WaitUtils.waitFor(3);
        ActionsUtils.actionsHoverOverOnElement(addProductPage.addToGallery);
        addProductPage.addToGallery.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User added second image to the gallery.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.virtualCheckbox);
        if (!addProductPage.virtualCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        }

        if (addProductPage.downloadableCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        } else {
            System.out.println("Downloadable Checkbox is not selected");
        }

        ExtentReportUtils.pass("User checked the Virtual checkbox.");

        addProductPage.productTitle.sendKeys("T-shirt");

        ExtentReportUtils.pass("User entered 'T-shirt' in the Product title field.");

        addProductPage.regularPrice.sendKeys("10");

        ExtentReportUtils.pass("User entered '10' in the Regular price field.");

        addProductPage.salePrice.sendKeys("5");
        BrowserUtils.frameSwitchTo("//iframe[@id='excerpt_ifr']");

        ExtentReportUtils.pass("User entered '5' in the Sale price field.");

        addProductPage.shortDescription.sendKeys("Red T-shirt");

        ExtentReportUtils.pass("User entered 'Red T-shirt' to the short description text box.");

        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.frameSwitchTo("//iframe[@id='description_ifr']");
        addProductPage.description.sendKeys("Defacto Red T-shirt for Men");
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User entered 'Defacto Red T-shirt for Men' to the description text box.");

        Driver.getDriver().switchTo().parentFrame();
        if (!addProductPage.clothesCategory.isSelected()) {
            addProductPage.clothesCategory.click();
        }
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User checked the 'Clothing' checkbox in the Category field.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.defactoProductBrand);
        if (!addProductPage.defactoProductBrand.isSelected()) {
            addProductPage.defactoProductBrand.click();
        }
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User checked the 'Defacto' checkbox in the Product brands field.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.manageStockCheckbox);
        if (!addProductPage.manageStockCheckbox.isSelected()) {
            addProductPage.manageStockCheckbox.click();
        } else {
            System.out.println("Manage Stock was already selected");
        }
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User checked the Manage Stock checkbox.");

        addProductPage.stockQuantity.clear();
        addProductPage.stockQuantity.sendKeys("1");

        ExtentReportUtils.pass("User entered '1' in the Stock Quantity field.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.submitButton);
        addProductPage.submitButton.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on Submit Button.");

        assertEquals(addProductPage.publishedTag.getText(), "Published");
        ExtentReportUtils.passAndCaptureScreenshot("User observes the success message and 'Published' field appears at the top.");
        ExtentReportUtils.info("Validation works as expected: A product is successfully added when all required fields are filled.");

    }

    @Test
    public void test02() {

        BrowserUtils.dropdownSelectByIndex(addProductPage.productTypeDropdown, 0);

        ExtentReportUtils.pass("User selected Simple Product option.");

        //Adding image
        addProductPage.addImage1.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on Add Image box.");

        addProductPage.selectImage1.click();
        WaitUtils.waitFor(3);

        robot.delay(2000);
        StringSelection selection = new StringSelection(pathOfImage1);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WaitUtils.waitFor(8);
        addProductPage.selectPastedImage.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User added first image to the gallery.");

///////////////////////// Product Title is missing

        ExtentReportUtils.info("User left the Product Title field empty.");

///////////////////////// Gallery image is missing

        ExtentReportUtils.info("User did not add the second image to the gallery.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.virtualCheckbox);
        if (!addProductPage.virtualCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        }

        if (addProductPage.downloadableCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        } else {
            System.out.println("Downloadable Checkbox is not selected");
        }

        ExtentReportUtils.pass("User checked the Virtual checkbox.");

        addProductPage.regularPrice.sendKeys("10");

        ExtentReportUtils.pass("User entered '10' in the Regular price field.");

        addProductPage.salePrice.sendKeys("5");

        ExtentReportUtils.pass("User entered '5' in the Sale price field.");

///////////////////////// Short Description is missing

        ExtentReportUtils.info("User left the Short description field empty.");

        BrowserUtils.frameSwitchTo("//iframe[@id='description_ifr']");
        addProductPage.description.sendKeys("Defacto Red T-shirt for Men");
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User entered 'Defacto Red T-shirt for Men' to the description text box.");

        Driver.getDriver().switchTo().parentFrame();

///////////////////////// Category is missing

        ExtentReportUtils.info("User left the Category field unselected.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.defactoProductBrand);
        if (!addProductPage.defactoProductBrand.isSelected()) {
            addProductPage.defactoProductBrand.click();
        }
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User checked the 'Defacto' checkbox in the Product brands field.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.manageStockCheckbox);
        if (!addProductPage.manageStockCheckbox.isSelected()) {
            addProductPage.manageStockCheckbox.click();
        } else {
            System.out.println("Manage Stock was already selected");
        }
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User checked the Manage Stock checkbox.");

        addProductPage.stockQuantity.clear();
        addProductPage.stockQuantity.sendKeys("1");

        ExtentReportUtils.pass("User entered '1' in the Stock Quantity field.");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.submitButton);
        addProductPage.submitButton.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("User clicked on Submit Button.");

        //System.out.println("addProductPage.incorrectInput.getText() = " + addProductPage.incorrectInput.getText());

        assertTrue(addProductPage.incorrectInput.getText().contains("Please insert Product Title before submit.\n" +
                "Gallery Images: This field is required.\n" +
                "Product cat: This field is required."));

        ExtentReportUtils.passAndCaptureScreenshot("User observes multiple warning messages.");
        ExtentReportUtils.info("Validation works as expected: Adding a product with empty required fields is unsuccessful.");
    }


    @AfterMethod
    public void tearDown() {

        ExtentReportUtils.flush();
        Driver.closeDriver();

    }


}
