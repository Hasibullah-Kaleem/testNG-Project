package myapp.tests;

import myapp.pages.AddProduct_Page;
import myapp.pages.HomePage;
import myapp.pages.StoreManager_Page;
import myapp.pages.accountPage.Login_Page;
import myapp.pages.accountPage.MyAccount_Page;
import myapp.pages.accountPage.ShippingAddressPage;
import myapp.utilities.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US_14_Goychak {
    HomePage homePage;
    Login_Page loginPage;
    MyAccount_Page myAccountPage;
    StoreManager_Page storeManagerPage;
    AddProduct_Page addProductPage;

    Robot robot;
    String pathOfPicture1 = "C:\\Users\\KM\\Desktop\\shirts\\redshirt.png";
    String pathOfPicture2 = "C:\\Users\\KM\\Desktop\\shirts\\shirt.png";

    @BeforeMethod
    public void setUp() throws AWTException {

        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerce_url"));
        homePage = new HomePage();
        loginPage = new Login_Page();
        myAccountPage = new MyAccount_Page();
        storeManagerPage = new StoreManager_Page();
        addProductPage = new AddProduct_Page();
        robot = new Robot();

        homePage.signInOption.click();
        loginPage.usernameEmailInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("Password"));
        loginPage.signInButton.click();

        ActionsUtils.actionsScrollDown();
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(homePage.myAccountTab);
        myAccountPage.storeManagerMenuTab.click();
        WaitUtils.waitFor(3);

        ActionsUtils.actionsHoverOverOnElement(storeManagerPage.productsMenuTab);
        storeManagerPage.addNew.click();
        WaitUtils.waitFor(3);


    }

    @Test
    public void test01() throws AWTException {

        BrowserUtils.dropdownSelectByIndex(addProductPage.productTypeDropdown, 0);
        //Adding image
        addProductPage.addImage1.click();
        WaitUtils.waitFor(3);
        addProductPage.selectImage1.click();
        WaitUtils.waitFor(3);

        robot.delay(2000);
        StringSelection selection = new StringSelection(pathOfPicture1);
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

        //Adding image to the gallery
        ActionsUtils.actionsHoverOverOnElement(addProductPage.addImage2);
        addProductPage.addImage2.click();
        ActionsUtils.actionsHoverOverOnElement(addProductPage.uploadImageTab);
        WaitUtils.waitFor(3);
        addProductPage.uploadImageTab.click();
        addProductPage.selectImage2.click();
        WaitUtils.waitFor(2);
        StringSelection selection2 = new StringSelection(pathOfPicture2);
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

        ActionsUtils.actionsHoverOverOnElement(addProductPage.virtualCheckbox);
        if (!addProductPage.virtualCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        }

        if (addProductPage.downloadableCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        } else {
            System.out.println("Downloadable Checkbox is not selected");
        }

        addProductPage.productTitle.sendKeys("T-shirt");
        addProductPage.regularPrice.sendKeys("10");
        addProductPage.salePrice.sendKeys("5");
        BrowserUtils.frameSwitchTo("//iframe[@id='excerpt_ifr']");
        addProductPage.shortDescription.sendKeys("Red T-shirt");
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.frameSwitchTo("//iframe[@id='description_ifr']");
        addProductPage.description.sendKeys("Defacto Red T-shirt for Men");
        WaitUtils.waitFor(3);

        Driver.getDriver().switchTo().parentFrame();
        if (!addProductPage.clothesCategory.isSelected()) {
            addProductPage.clothesCategory.click();
        }
        WaitUtils.waitFor(3);

        ActionsUtils.actionsHoverOverOnElement(addProductPage.defactoProductBrand);
        if (!addProductPage.defactoProductBrand.isSelected()) {
            addProductPage.defactoProductBrand.click();
        }
        WaitUtils.waitFor(3);

        ActionsUtils.actionsHoverOverOnElement(addProductPage.manageStockCheckbox);
        if (!addProductPage.manageStockCheckbox.isSelected()) {
            addProductPage.manageStockCheckbox.click();
        } else {
            System.out.println("Manage Stock was already selected");
        }
        WaitUtils.waitFor(3);

        addProductPage.stockQuantity.clear();
        addProductPage.stockQuantity.sendKeys("1");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.submitButton);
        addProductPage.submitButton.click();
        WaitUtils.waitFor(3);

        assertEquals(addProductPage.publishedTag.getText(), "Published");

    }

    @Test
    public void test02() {

        BrowserUtils.dropdownSelectByIndex(addProductPage.productTypeDropdown, 0);

        //Adding image
        addProductPage.addImage1.click();
        WaitUtils.waitFor(3);
        addProductPage.selectImage1.click();
        WaitUtils.waitFor(3);

        robot.delay(2000);
        StringSelection selection = new StringSelection(pathOfPicture1);
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

///////////////////////// Gallery image is missing

        ActionsUtils.actionsHoverOverOnElement(addProductPage.virtualCheckbox);
        if (!addProductPage.virtualCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        }

        if (addProductPage.downloadableCheckbox.isSelected()) {
            addProductPage.virtualCheckbox.click();
        } else {
            System.out.println("Downloadable Checkbox is not selected");
        }

///////////////////////// Product Title is missing

        addProductPage.regularPrice.sendKeys("10");
        addProductPage.salePrice.sendKeys("5");

///////////////////////// Short Description is missing

        BrowserUtils.frameSwitchTo("//iframe[@id='description_ifr']");
        addProductPage.description.sendKeys("Defacto Red T-shirt for Men");
        WaitUtils.waitFor(3);

        Driver.getDriver().switchTo().parentFrame();

///////////////////////// Category is missing

        ActionsUtils.actionsHoverOverOnElement(addProductPage.defactoProductBrand);
        if (!addProductPage.defactoProductBrand.isSelected()) {
            addProductPage.defactoProductBrand.click();
        }
        WaitUtils.waitFor(3);

        ActionsUtils.actionsHoverOverOnElement(addProductPage.manageStockCheckbox);
        if (!addProductPage.manageStockCheckbox.isSelected()) {
            addProductPage.manageStockCheckbox.click();
        } else {
            System.out.println("Manage Stock was already selected");
        }
        WaitUtils.waitFor(3);

        addProductPage.stockQuantity.clear();
        addProductPage.stockQuantity.sendKeys("1");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.submitButton);
        addProductPage.submitButton.click();
        WaitUtils.waitFor(3);

        System.out.println("addProductPage.incorrectInput.getText() = " + addProductPage.incorrectInput.getText());

        assertTrue(addProductPage.incorrectInput.getText().contains("Please insert Product Title before submit.\n" +
                "Gallery Images: This field is required.\n" +
                "Product cat: This field is required."));


    }


    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}
