package myapp.pages.accountPage;

import myapp.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class US_03_BillingAddressPage {

    public US_03_BillingAddressPage() {


        PageFactory.initElements(Driver.getDriver(), this);


    }

   @FindBy(xpath = "//a[.//span[text()='Sign In']]")
    public WebElement signInButton;


    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(id= "password")
    public WebElement password;

    @FindBy(xpath ="//button[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement addressOption;

    @FindBy(css="a[href*='edit-address']")
    public WebElement editBillingAddressButton;

    // @FindBy(xpath="//a[contains(text(), 'Edit') or contains(@href, 'edit-address')]")

  @FindBy(xpath ="//*[contains(@id, 'billing_first_name']")
 //@FindBy(id = "billing_firstName")
    public WebElement billingFirstName;


    @FindBy(id = "billing_last_name")
    public WebElement billingLastName;

    @FindBy (id= "Billing_company")
    public WebElement billingCompany;

    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement billingCountry;

    @FindBy(id = "billing_streetAddress")
    public WebElement streetAddress;

    @FindBy(id="billing_city")
    public WebElement billingCity;

    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement billingState;

    @FindBy(id="billing_postcode")
    public WebElement billingPostcode;

    @FindBy(id="billing_phone")
    public WebElement billingPhone;

    @FindBy(id="billing_email")
    public WebElement billingEmail;

    @FindBy(xpath ="//button[@name='save_address']")
    public WebElement saveButton;








}










