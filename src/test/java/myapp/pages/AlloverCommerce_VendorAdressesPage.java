package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_VendorAdressesPage {

    public AlloverCommerce_VendorAdressesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//main[@id='main']//div[3]//a")
    public WebElement billingAdressButton;

    @FindBy(id="billing_first_name")
    public WebElement billingFirstNameInput;

    @FindBy(id="billing_last_name")
    public WebElement billingLastNameInput;

    @FindBy(id="billing_company")
    public WebElement billingCompanyInput;

    @FindBy(xpath="//p[@id='billing_country_field']")
    public WebElement billingCountry;

    @FindBy(id="billing_address_1")
    public WebElement billingStreetAddress;

    @FindBy(id="billing_address_2")
    public WebElement billingStreetAddress2;

    @FindBy(id="billing_postcode")
    public WebElement billingPostcode;

    @FindBy(id="billing_city")
    public WebElement billingCity;

    @FindBy(id="select2-billing_state-container")
    public WebElement billingState;

    @FindBy(id="billing_phone")
    public WebElement billingPhone;

    @FindBy(id="billing_email")
    public WebElement billingEmail;

    @FindBy(name="save_address")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='main']/div/div/div/div/div/div/div/div[1]/div")
    public WebElement successMsg;

    @FindBy(xpath = "//*[@id='main']/div/div/div/div/div/div/div/div/ul/li")
    public WebElement errorMsg;






}
