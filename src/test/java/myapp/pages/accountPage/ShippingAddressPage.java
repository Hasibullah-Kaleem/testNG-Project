package myapp.pages.accountPage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {

    public ShippingAddressPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "//a[text()='Edit Your Shipping Address']")
    public WebElement editShippingAddress;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addressSuccessfullyChangedAlert; //Address changed successfully.
    @FindBy(id = "shipping_first_name")
    public WebElement firstNameShipping;
    @FindBy(id = "shipping_last_name")
    public WebElement lastNameShipping;
    @FindBy(id = "shipping_address_1")
    public WebElement streetAddressShipping;
    @FindBy(id = "shipping_city")
    public WebElement cityShipping;
    @FindBy(id = "shipping_postcode")
    public WebElement zipCodeShipping;
    @FindBy(id = "shipping_state")
    public WebElement stateShipping;
    @FindBy(xpath = "//select[@id='shipping_country']")
    public WebElement countryDropDownShipping;
    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveAddressButton;
    @FindBy(xpath = "//li[text()='Last name is a required field.']")
    public WebElement incorrectLastName;
    @FindBy(xpath = "//li[text()='Street address is a required field.']")
    public WebElement incorrectStreetAddress;
    @FindBy(xpath = "//li[text()='Postcode / ZIP is a required field.']")
    public WebElement incorrectZip;
    @FindBy(xpath = "//li[text()='Town / City is a required field.']")
    public WebElement incorrectCity;












}
