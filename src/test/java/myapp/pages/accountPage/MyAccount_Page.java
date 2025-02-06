package myapp.pages.accountPage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page {


    public MyAccount_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (linkText = "Addresses")
    public WebElement addressesMenuTab;

    @FindBy (linkText = "Store Manager")
    public WebElement storeManagerMenuTab;

}
