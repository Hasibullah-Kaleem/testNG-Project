package myapp.pages.accountPage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login_Page {

    public Login_Page(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "//input[@id='username']")
    public WebElement usernameEmailInput;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInButton;

}
