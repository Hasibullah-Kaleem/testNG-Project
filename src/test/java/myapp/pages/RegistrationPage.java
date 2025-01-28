package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "reg_username")
    public WebElement regUserNameInput;

    @FindBy (id = "reg_email")
    public WebElement regEmailInput;

    @FindBy (id = "reg_password")
    public WebElement regPasswordInput;

    @FindBy (id = "register-policy")
    public WebElement registerPolicy;

    @FindBy (css = "button[value='Sign Up']")
    public WebElement signUpButton;

    @FindBy (xpath = "//p[contains(text(),'An account is already registered with your email address')]")
    public WebElement regEmailWarningMsg;

    @FindBy (xpath = "//a[normalize-space()='Please log in.']")
    public WebElement pleaseLogInMsg;
}
