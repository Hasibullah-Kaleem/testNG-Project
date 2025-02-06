package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_HomePage {
    public AlloverCommerce_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Sign In")
    public WebElement signInIcon;

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccoutText;

    @FindBy(linkText = "My Account")
    public WebElement myAccout;

    @FindBy(linkText = "Sign Out")
    public WebElement signOutButton;


}
