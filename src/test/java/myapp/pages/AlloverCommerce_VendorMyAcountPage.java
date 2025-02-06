package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlloverCommerce_VendorMyAcountPage {

    public AlloverCommerce_VendorMyAcountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;

    @FindBy(linkText = "Orders")
    public WebElement orders;

    @FindBy(linkText = "Downloads")
    public WebElement downloads;

    @FindBy(linkText = "Addresses")
    public WebElement addresses;

    @FindBy(linkText = "Account details")
    public WebElement accountDetails;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlist;

    @FindBy(linkText = "Support Tickets")
    public WebElement supportTickets;

    @FindBy(linkText = "Followings")
    public WebElement followings;

    @FindBy(linkText = "Logout")
    public WebElement logout;

    @FindBy(xpath="//main[@id='main']//nav//li")
    public List<WebElement> allOptions;

}
