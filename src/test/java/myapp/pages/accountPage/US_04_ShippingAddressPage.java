package myapp.pages.accountPage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class US_04_ShippingAddressPage {




    @Test

    public void test(){

     PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[.//span[text()='Sign In']]")
   public WebElement signInButton;

    @FindBy(id= "username")
    public WebElement username;

    @FindBy(id= "password")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;

    @FindBy(id="shipping_first_name")
    public WebElement shippingAddress;

    @FindBy(id="shipping_last_name")
    public WebElement ShippingLastname;

    @FindBy(xpath = "//span[@id='select-shipping_country-container']")
    public WebElement shippingCountryContainer;

    @FindBy(id="shipping_address_1")
    public WebElement shippingAddress1;

    @FindBy(id="shipping_city")
    public WebElement shippingCity;

    @FindBy(xpath="//span[@id=select-shipping_state-container")
    public WebElement shippingStateContainer;

    @FindBy(id="shipping_postcode")
    public WebElement shippingPostcode;

    @FindBy(xpath ="//button[@name='save_address']")
    public WebElement addressButton;





















}
