package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[normalize-space()='Register']")
    public WebElement registerOption;

    @FindBy (xpath = "//span[normalize-space()='Sign Out']")
    public WebElement signOutOption;

    @FindBy (xpath = "//a[@class='login inline-type']")
    public WebElement signInOption;

    @FindBy (linkText = "My Account")
    public WebElement myAccountTab;
}
